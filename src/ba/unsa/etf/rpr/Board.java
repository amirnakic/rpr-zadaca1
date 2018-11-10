package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<ChessPiece> activeFigures = new ArrayList<>();

    public Board() {
        activeFigures.add(new Pawn("A2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("B2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("C2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("D2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("E2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("F2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("G2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("H2", ChessPiece.Color.WHITE));
        activeFigures.add(new Pawn("A7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("B7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("C7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("D7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("E7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("F7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("G7", ChessPiece.Color.BLACK));
        activeFigures.add(new Pawn("H7", ChessPiece.Color.BLACK));
        activeFigures.add(new Rook("A1", ChessPiece.Color.WHITE));
        activeFigures.add(new Rook("H1", ChessPiece.Color.WHITE));
        activeFigures.add(new Rook("A8", ChessPiece.Color.BLACK));
        activeFigures.add(new Rook("H8", ChessPiece.Color.BLACK));
        activeFigures.add(new Knight("B1", ChessPiece.Color.WHITE));
        activeFigures.add(new Knight("G1", ChessPiece.Color.WHITE));
        activeFigures.add(new Knight("B8", ChessPiece.Color.BLACK));
        activeFigures.add(new Knight("G8", ChessPiece.Color.BLACK));
        activeFigures.add(new Bishop("C1", ChessPiece.Color.WHITE));
        activeFigures.add(new Bishop("F1", ChessPiece.Color.WHITE));
        activeFigures.add(new Bishop("C8", ChessPiece.Color.BLACK));
        activeFigures.add(new Bishop("F8", ChessPiece.Color.BLACK));
        activeFigures.add(new Queen("D1", ChessPiece.Color.WHITE));
        activeFigures.add(new Queen("D8", ChessPiece.Color.BLACK));
        activeFigures.add(new King("E1", ChessPiece.Color.WHITE));
        activeFigures.add(new King("E8", ChessPiece.Color.BLACK));
    }

    public List<ChessPiece> getActiveFigures() {
        return activeFigures;
    }

    //metoda vraca 0 ako je rijec o obicnom potezu - koji je korektan, ali ne jede drugu figuru
    //metoda vraca 1 ako je rijec o potezu koji je korektan, i pritom pojede drugu figuru
    //metoda vraca -1 ako je potrebno baciti izuzetak, iz bilo kojeg razloga koji znaci neispravnost poteza
    public int isMoveEatingMove(String position, ChessPiece.Color color) {
        position = position.toUpperCase();
        for (ChessPiece testFigure : getActiveFigures()) {
            if (testFigure.getPosition().equals(position)) {
                if (testFigure.getColor() == color) {
                    return -1;
                } else return 1;
            }
        }
        return 0;
    }

    public void removeFigure(String position) {
        position = position.toUpperCase();
        for (ChessPiece figure : getActiveFigures())
            if (figure.getPosition().equals(position)) {
                getActiveFigures().remove(figure);
                return;
            }
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalArgumentException, IllegalChessMoveException {
        for (int i = 0; i < getActiveFigures().size(); i++) {
            ChessPiece figure = getActiveFigures().get(i);
            position = position.toUpperCase();
            List<String> temp = new ArrayList<>();
            if (figure.getClass() == type && figure.getColor() == color) {
                if (figure instanceof King) {
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else if (((King) figure).isKingsMoveCorrect(position)) {
                        if (isMoveEatingMove(position, figure.getColor()) == 1) {
                            removeFigure(position);
                            figure.move(position);
                            return;
                        } else {
                            figure.move(position);
                            return;
                        }
                    }
                } else if (figure instanceof Knight) {
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else if (((Knight) figure).isKnightsMoveCorrect(position)) {
                        if (isMoveEatingMove(position, figure.getColor()) == 1) {
                            removeFigure(position);
                            figure.move(position);
                            return;
                        } else {
                            figure.move(position);
                            return;
                        }
                    }
                } else if (figure instanceof Queen) {
                    temp = ((Queen) figure).getQueensPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getActiveFigures())
                        if (temp.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Illegal move.");
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else if (((Queen) figure).isQueensMoveCorrect(position)) {
                        if (isMoveEatingMove(position, figure.getColor()) == 0) {
                            figure.move(position);
                            return;
                        } else {
                            removeFigure(position);
                            figure.move(position);
                            return;
                        }
                    }
                } else if (figure instanceof Rook) {
                    temp = ((Rook) figure).getRooksPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getActiveFigures())
                        if (temp.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Illegal move.");
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else if (((Rook) figure).isRooksMoveCorrect(position)) {
                        if (isMoveEatingMove(position, figure.getColor()) == 1) {
                            removeFigure(position);
                            figure.move(position);
                            return;
                        } else {
                            figure.move(position);
                            return;
                        }
                    }
                } else if (figure instanceof Bishop) {
                    temp = ((Bishop) figure).getBishopsPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getActiveFigures())
                        if (temp.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Illegal move.");
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else if (((Bishop) figure).isBishopsMoveCorrect(position)) {
                        if (isMoveEatingMove(position, figure.getColor()) == 0) {
                            figure.move(position);
                            return;
                        } else {
                            removeFigure(position);
                            figure.move(position);
                            return;
                        }
                    }
                } else if (figure instanceof Pawn) {
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Illegal move.");
                    else {
                        if (((Pawn) figure).isPawnsVerticalMoveCorrect(position) && (isMoveEatingMove(position, figure.getColor()) == 0)) {
                            figure.move(position);
                            return;
                        } else if (((Pawn) figure).isPawnsDiagonalMoveCorrect(position) && (isMoveEatingMove(position, figure.getColor()) == 1)) {
                            removeFigure(position);
                            ((Pawn) figure).eat(position);
                            return;
                        }
                    }
                }
            }
        }
        throw new IllegalChessMoveException("Illegal move.");
    }

    public void move(String oldPosition, String newPosition) throws IllegalArgumentException, IllegalChessMoveException {
        oldPosition = oldPosition.toUpperCase();
        newPosition = newPosition.toUpperCase();
        for (ChessPiece figure : getActiveFigures())
            if (figure.getPosition().equals(oldPosition)) {
                this.move(figure.getClass(), figure.getColor(), newPosition);
                return;
            }
        throw new IllegalArgumentException("Illegal move.");
    }

    public boolean isCheck(ChessPiece.Color color) {
        boolean canItBeCheck = false;
        String currentPositionOfKing = "";
        for (ChessPiece figure : getActiveFigures()) {
            if (figure instanceof King) {
                if (figure.getColor() == color)
                    currentPositionOfKing = figure.getPosition();
            }
        }
        List<String> temp = new ArrayList<>();
        for (ChessPiece figure : getActiveFigures()) {
            if (figure instanceof Knight && (figure.getColor() != color)) {
                if (((Knight) figure).isKnightsMoveCorrect(currentPositionOfKing)) return true;
            } else if (figure instanceof Bishop && (figure.getColor() != color)) {
                if (((Bishop) figure).isBishopsMoveCorrect(currentPositionOfKing)) {
                    temp = ((Bishop) figure).getBishopsPositionsWhileMoving(currentPositionOfKing);
                    canItBeCheck = true;
                }
            } else if (figure instanceof Rook && (figure.getColor() != color)) {
                if (((Rook) figure).isRooksMoveCorrect(currentPositionOfKing)) {
                    temp = ((Rook) figure).getRooksPositionsWhileMoving(currentPositionOfKing);
                    canItBeCheck = true;
                }
            } else if (figure instanceof King && (figure.getColor() != color)) {
                if (((King) figure).isKingsMoveCorrect(currentPositionOfKing)) return true;
            } else if (figure instanceof Pawn && (figure.getColor() != color)) {
                if (((Pawn) figure).isPawnsDiagonalMoveCorrect(currentPositionOfKing)) return true;
            } else if (figure instanceof Queen && (figure.getColor() != color))
                if (((Queen) figure).isQueensMoveCorrect(currentPositionOfKing)) {
                    temp = ((Queen) figure).getQueensPositionsWhileMoving(currentPositionOfKing);
                    canItBeCheck = true;
                }
        }
        if (canItBeCheck) {
            for (ChessPiece figure : getActiveFigures())
                if (temp.contains(figure.getPosition()))
                    return false;
            return true;
        }
        return false;
    }
}
