package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(String position, ChessPiece.Color color) {
        super(position, color);
    }

    //kraljica se krece u svim mogucim pravcima za neogranicen broj polja i pritom ne moze preskakati figure
    public boolean isQueensMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = Math.abs(currentPosition.charAt(0) - position.charAt(0));
        int result2 = Math.abs((currentPosition.charAt(1) - '0') - (position.charAt(1) - '0'));
        if (result1 == result2) return true;
        else if (result1 == 0 && result2 != 0) return true;
        else if (result2 == 0 && result1 != 0) return true;
        return false;
    }

    //metoda vraca listu polja koja kraljica posjeti pri kretanju od pocetne do krajnje pozicije
    public List<String> getQueensPositionsWhileMoving(String position) {
        List<String> result = new ArrayList<>();
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = position.charAt(0) - currentPosition.charAt(0);
        int result2 = (position.charAt(1) - '0') - (currentPosition.charAt(1) - '0');
        if (Math.abs(result1) == Math.abs(result2)) {
            if (result1 > 0 && result2 > 0) {
                for (int i = 1; i < result1; i++) {
                    Character c1 = (char) (currentPosition.charAt(0) + i);
                    int c2 = currentPosition.charAt(1) - '0' + i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else if (result1 > 0 && result2 < 0) {
                for (int i = 1; i < result1; i++) {
                    Character c1 = (char) (currentPosition.charAt(0) + i);
                    int c2 = currentPosition.charAt(1) - '0' - i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else if (result1 < 0 && result2 < 0) {
                for (int i = 1; i < Math.abs(result1); i++) {
                    Character c1 = (char) (currentPosition.charAt(0) - i);
                    int c2 = currentPosition.charAt(1) - '0' - i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else {
                for (int i = 1; i < Math.abs(result1); i++) {
                    Character c1 = (char) (currentPosition.charAt(0) - i);
                    int c2 = currentPosition.charAt(1) - '0' + i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            }
        } else if (result1 == 0) {
            if (result2 > 0) {
                for (int i = 1; i < result2; i++) {
                    Character c1 = currentPosition.charAt(0);
                    int c2 = currentPosition.charAt(1) - '0' + i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else {
                for (int i = 1; i < Math.abs(result2); i++) {
                    Character c1 = currentPosition.charAt(0);
                    int c2 = currentPosition.charAt(1) - '0' - i;
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            }
        } else if (result2 == 0) {
            if (result1 > 0) {
                for (int i = 1; i < result1; i++) {
                    Character c1 = (char) (currentPosition.charAt(0) + i);
                    int c2 = currentPosition.charAt(1) - '0';
                    String temp = c1.toString() + c2;
                    result.add(temp);
                }
            } else {
                for (int i = 1; i < Math.abs(result1); i++) {
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
        if (!checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else if (!isQueensMoveCorrect(position)) throw new IllegalChessMoveException("Illegal move.");
        else setPosition(position);
    }
}
