package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(String position, ChessPiece.Color color) {
        super(position, color);
    }

    //konj se moze kretati na nacin da njegova nova i stara pozicija formiraju slovo L na sve raspolozive nacine, pri cemu moze preskakati druge figure
    public boolean isKnightsMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int result1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int result2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (result1 != result2 && list.contains(result1) && list.contains(result2)) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else if (!isKnightsMoveCorrect(position)) throw new IllegalChessMoveException("Illegal move.");
        else setPosition(position);
    }
}
