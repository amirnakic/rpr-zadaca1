package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Rook extends ChessPiece {
    public Rook(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isRooksMoveCorrect(String position) {
        String currentPosition = getPosition();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 == 0 && list.contains(rezultat2)) return true; //vertikalno kretanje
        else if (rezultat2 == 0 && list.contains(rezultat1)) return true; //horizontalno kretanje
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {

    }
}
