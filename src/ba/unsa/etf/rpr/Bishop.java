package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    public Bishop(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isBishopsMoveCorrect(String position) { //lovac se krece u svim mogucim dijagonalnim pravcima za neogranicen broj polja i pritom ne moze preskakati druge figure
        String currentPosition = getPosition();
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 == rezultat2) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isBishopsMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
