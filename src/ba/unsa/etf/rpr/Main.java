package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             b.removeFigure("a2");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "a4");
             System.out.println(b.getActiveFigures().size());

         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
