package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isKnightsMoveCorrect(String position) { //konj se moze kretati na nacin da njegova nova i stara pozicija formiraju slovo L na sve raspolozive nacine, pri cemu moze preskakati druge figure
        String currentPosition = getPosition();
        position = position.toUpperCase();
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 != rezultat2 && lista.contains(rezultat1) && lista.contains(rezultat2)) return true;
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isKnightsMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
