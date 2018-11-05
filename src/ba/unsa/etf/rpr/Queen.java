package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Queen extends ChessPiece {
    public Queen(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isQueensMoveCorrect(String position) {
        String currentPosition = this.getPosition();
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
        if (list.contains(rezultat1) && list.contains(rezultat2) && rezultat1 == rezultat2)
            return true; //dijagonalno kretanje
        else if (rezultat1 == 0 && list.contains(rezultat2)) return true; //vertikalno kretanje
        else if (rezultat2 == 0 && list.contains(rezultat1)) return true; //horizontalno kretanje
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
    }
}
