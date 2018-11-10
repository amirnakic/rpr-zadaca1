package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class King extends ChessPiece {
    public King(String position, ChessPiece.Color color) {
        super(position, color);
    }

    //kralj se moze kretati u svim mogucim pravcima za po jedno polje
    public boolean isKingsMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int result1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int result2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (list.contains(result1) && list.contains(result2)) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else if (!isKingsMoveCorrect(position)) throw new IllegalChessMoveException("Illegal move.");
        else setPosition(position);
    }
}
