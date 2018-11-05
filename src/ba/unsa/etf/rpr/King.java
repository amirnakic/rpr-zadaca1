package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class King extends ChessPiece {
    public King(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isKingsMoveCorrect(String position) {
        String currentPosition = getPosition();
        ArrayList<Integer> list = new ArrayList<>(); //sadrži moguće razlike trenutne i nove pozicije za kralja
        list.add(0);
        list.add(1);
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (list.contains(rezultat1) && list.contains(rezultat2)) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isKingsMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
