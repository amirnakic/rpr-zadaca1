package ba.unsa.etf.rpr;

import java.util.List;

public class Board {
    private List<ChessPiece> aktivneBijeleFigure;
    private List<ChessPiece> aktivneCrneFigure;

    public Board() {
        aktivneBijeleFigure.add(new Rook("A1", ChessPiece.Color.WHITE));
        aktivneBijeleFigure.add(new Rook("H1", ChessPiece.Color.WHITE));
        aktivneCrneFigure.add(new Rook("A8", ChessPiece.Color.BLACK));
        aktivneCrneFigure.add(new Rook("H8", ChessPiece.Color.BLACK));
        aktivneBijeleFigure.add(new Knight("B1", ChessPiece.Color.WHITE));
        aktivneBijeleFigure.add(new Knight("G1", ChessPiece.Color.WHITE));
        aktivneCrneFigure.add(new Knight("B8", ChessPiece.Color.BLACK));
        aktivneCrneFigure.add(new Knight("G8", ChessPiece.Color.BLACK));
        aktivneBijeleFigure.add(new Bishop("C1", ChessPiece.Color.WHITE));
        aktivneBijeleFigure.add(new Bishop("F1", ChessPiece.Color.WHITE));
        aktivneCrneFigure.add(new Bishop("C8", ChessPiece.Color.BLACK));
        aktivneCrneFigure.add(new Bishop("F8", ChessPiece.Color.BLACK));
        aktivneBijeleFigure.add(new Queen("D1", ChessPiece.Color.WHITE));
        aktivneCrneFigure.add(new Queen("D8", ChessPiece.Color.BLACK));
        aktivneBijeleFigure.add(new King("E1", ChessPiece.Color.WHITE));
        aktivneCrneFigure.add(new King("E8", ChessPiece.Color.BLACK));
        for (int i = 0; i < 8; i++) {
            aktivneBijeleFigure.add(new Pawn(String.valueOf('A' + i) + "2", ChessPiece.Color.WHITE));
            aktivneCrneFigure.add(new Pawn(String.valueOf('A' + i) + "7", ChessPiece.Color.BLACK));
        }
    }
}
