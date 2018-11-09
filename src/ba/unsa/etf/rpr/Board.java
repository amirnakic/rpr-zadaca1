package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Iterator;
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

    public int isMoveEatingMove(String position, ChessPiece.Color color) {
        for (ChessPiece testFigure : getActiveFigures()) {
            if (testFigure.getPosition().equals(position)) {
                if (testFigure.getColor() == color) {
                    return -1; //vraca -1 ako nije rijec o eatingMove-u i ako treba baciti izuzetak
                } else return 1; //vraca 1 ako je rijec o eatingMove-u
            }
        }
        return 0; //vraca 0 ako je rijec o obicnom Move-u
    }

    public void removeFigure(String position) {
        List<ChessPiece> tempList = new ArrayList<>();
        for (ChessPiece figure : getActiveFigures())
            if (figure.getPosition().equals(position) == false)
                tempList.add(figure);
        getActiveFigures().clear();
        getActiveFigures().addAll(tempList);
        tempList.clear();
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalArgumentException, IllegalChessMoveException {
        for (int i = 0; i < getActiveFigures().size(); i++) {
            ChessPiece figure = getActiveFigures().get(i);
            position = position.toUpperCase();
            if (figure.getClass() == type && figure.getColor() == color) {
                if (figure instanceof King || figure instanceof Knight) {
                    figure.move(position);
                } else if (figure instanceof Queen) {
                    figure.move(position);
                    List<String> positions = ((Queen) figure).getQueensPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getActiveFigures()) {
                        if (positions.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                    }
                } else if (figure instanceof Rook) {
                    figure.move(position);
                    List<String> positions = ((Rook) figure).getRooksPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getActiveFigures()) {
                        if (positions.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                    }
                } else if (figure instanceof Bishop) {
                    if (isMoveEatingMove(position, figure.getColor()) == -1)
                        throw new IllegalChessMoveException("Parameter is incorrect.");
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
                        throw new IllegalChessMoveException("Parameter is incorrect.");
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
        throw new IllegalChessMoveException("Parameter is incorrect.");
    }

    public void move(String oldPosition, String newPosition) throws IllegalArgumentException, IllegalChessMoveException {
        oldPosition = oldPosition.toUpperCase();
        newPosition = newPosition.toUpperCase();
        for (ChessPiece figure : getActiveFigures())
            if (figure.getPosition().equals(oldPosition)) {
                this.move(figure.getClass(), figure.getColor(), newPosition);
                return;
            }
        throw new IllegalArgumentException("Parameter is incorrect.");
    }

    public boolean isCheck(ChessPiece.Color color) {
        return true;
    }
}
