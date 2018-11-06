package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isPawnsMoveCorrect(String position) {
        String currentPosition = getPosition();
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 == 0 && rezultat2 == 1) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isPawnsMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
