package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    public Queen(String position, ChessPiece.Color color) {
        super(position, color);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
    }
}
