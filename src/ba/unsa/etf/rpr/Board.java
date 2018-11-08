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
            if (figure.getClass() == type && figure.getColor() == color) {
                if (figure instanceof King || figure instanceof Knight) {
                    figure.move(position);
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
            } else throw new IllegalChessMoveException("Parameter is incorrect.");
        }
    }
}
