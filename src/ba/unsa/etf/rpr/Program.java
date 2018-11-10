package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public boolean isInputCorrect(String input) {
        List<Integer> correctNumberOfCharsInInput = new ArrayList<>();
        correctNumberOfCharsInInput.add(1);
        correctNumberOfCharsInInput.add(2);
        correctNumberOfCharsInInput.add(3);
        if (input.isEmpty() || !correctNumberOfCharsInInput.contains(input.length()))
            return false;
        char first, second, third;
        if (input.length() == 1 && !input.equals("X"))
            return false;
        else if (input.length() == 2) {
            second = input.charAt(0);
            third = input.charAt(1);
        } else {
            first = input.charAt(0);
            second = input.charAt(1);
            third = input.charAt(2);
            if (Character.isDigit(first))
                return false;
            else if ("KQRBN".indexOf(first) == -1)
                return false;
        }
        if (Character.isWhitespace(second) || Character.isWhitespace(third))
            return false;
        else if (Character.isDigit(second) || Character.isLetter(third))
            return false;
        else if ("ABCDEFGHabcdefgh".indexOf(second) == -1 || "12345678".indexOf(third) == -1)
            return false;
        return true;
    }
     public static void main(String[] args) {
         /*Board b = new Board();
         String input = "";
         boolena correct = false;
         while(true) {
              System.out.println("White move: ");
              while(correct)
         }*/
     }
}
