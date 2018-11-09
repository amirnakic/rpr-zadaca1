package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<ChessPiece> aktivneFigure = new ArrayList<>();

    public Board() {
        aktivneFigure.add(new Rook("A1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Rook("H1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Rook("A8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Rook("H8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Knight("B1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Knight("G1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Knight("B8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Knight("G8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Bishop("C1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Bishop("F1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Bishop("C8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Bishop("F8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Queen("D1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Queen("D8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new King("E1", ChessPiece.Color.WHITE));
        aktivneFigure.add(new King("E8", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("A2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("B2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("C2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("D2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("E2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("F2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("G2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("H2", ChessPiece.Color.WHITE));
        aktivneFigure.add(new Pawn("A7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("B7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("C7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("D7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("E7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("F7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("G7", ChessPiece.Color.BLACK));
        aktivneFigure.add(new Pawn("H7", ChessPiece.Color.BLACK));
    }

    public List<ChessPiece> getAktivneFigure() {
        return aktivneFigure;
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalArgumentException, IllegalChessMoveException {
        for (int i = 0; i < getAktivneFigure().size(); i++) {
            ChessPiece figure = getAktivneFigure().get(i);
            String oldPosition = figure.getPosition();
            position = position.toUpperCase();
            if (figure.getClass() == type && figure.getColor() == color) {
                if (figure instanceof King || figure instanceof Knight) {
                    figure.move(position);
                } else if (figure instanceof Queen) {
                    figure.move(position);
                    List<String> positions = ((Queen) figure).getQueensPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getAktivneFigure()) {
                        if (positions.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                    }
                } else if (figure instanceof Rook) {
                    figure.move(position);
                    List<String> positions = ((Rook) figure).getRooksPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getAktivneFigure()) {
                        if (positions.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                    }
                } else if (figure instanceof Bishop) {
                    figure.move(position);
                    List<String> positions = ((Bishop) figure).getBishopsPositionsWhileMoving(position);
                    for (ChessPiece testFigure : getAktivneFigure()) {
                        if (positions.contains(testFigure.getPosition()))
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                    }
                } else if (figure instanceof Pawn) {
                    if ((oldPosition.charAt(0) - position.charAt(0)) == 0) {
                        figure.move(position);
                    } else ((Pawn) figure).eat(position);

                }
                for (ChessPiece testFigure : getAktivneFigure()) {
                    if (testFigure.getPosition() == position) {
                        if (testFigure.getColor() == color) {
                            figure.setPosition(oldPosition);
                            throw new IllegalChessMoveException("Parameter is incorrect.");
                        } else {
                            getAktivneFigure().remove(testFigure);
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
        for (ChessPiece figure : getAktivneFigure())
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
