package ba.unsa.etf.rpr;

import java.util.List;

public class Board {
    private List<ChessPiece> aktivneFigure;

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
        for (int i = 0; i < 8; i++) {
            aktivneFigure.add(new Pawn(String.valueOf('A' + i) + "2", ChessPiece.Color.WHITE));
            aktivneFigure.add(new Pawn(String.valueOf('A' + i) + "7", ChessPiece.Color.BLACK));
        }
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalArgumentException, IllegalChessMoveException {
    }
}
