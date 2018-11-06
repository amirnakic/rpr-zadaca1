package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    public Rook(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isRooksMoveCorrect(String position) { //top se krece u svim mogucim horizontalnim i vertikalnim pravcima za neogranicen broj polja i pritom ne moze preskakati figure
        String currentPosition = getPosition();
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 == 0 && rezultat2 != 0) return true; //vertikalno kretanje
        else if (rezultat2 == 0 && rezultat1 != 0) return true; //horizontalno kretanje
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isRooksMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
