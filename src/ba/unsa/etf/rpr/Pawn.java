package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String position, ChessPiece.Color color) {
        super(position, color);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
    }
}
