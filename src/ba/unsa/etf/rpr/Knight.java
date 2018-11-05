package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {
    public Knight(String position, ChessPiece.Color color) {
        super(position, color);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
    }
}
