package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    public Rook(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isRooksMoveCorrect(String position) { //top se krece u svim mogucim horizontalnim i vertikalnim pravcima za neogranicen broj polja i pritom ne moze preskakati figure
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int rezultat1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int rezultat2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (rezultat1 == 0 && rezultat2 != 0) return true; //vertikalno kretanje
        else if (rezultat2 == 0 && rezultat1 != 0) return true; //horizontalno kretanje
        return false;
    }

    public List<String> getRooksPositionsWhileMoving(String position) {
        List<String> result = new ArrayList<>();
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int rezultat1 = position.charAt(0) - currentPosition.charAt(0);
        int rezultat2 = (position.charAt(1) - '0') - (currentPosition.charAt(1) - '0');
        if (rezultat1 == 0) {
            if (rezultat2 > 0) {
                for (int i = 1; i < rezultat2; i++) {
                    Character c1 = currentPosition.charAt(0);
                    int c2 = currentPosition.charAt(1) - '0' + i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else {
                for (int i = 1; i < Math.abs(rezultat2); i++) {
                    Character c1 = currentPosition.charAt(0);
                    int c2 = currentPosition.charAt(1) - '0' - i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            }
        } else if (rezultat2 == 0) {
            if (rezultat1 > 0) {
                for (int i = 1; i < rezultat1; i++) {
                    Character c1 = (char) (currentPosition.charAt(0) + i);
                    int c2 = currentPosition.charAt(1) - '0';
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else {
                for (int i = 1; i < Math.abs(rezultat1); i++) {
                    Character c1 = (char) (currentPosition.charAt(0) - i);
                    int c2 = currentPosition.charAt(1) - '0';
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            }
        }
        return result;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isRooksMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
