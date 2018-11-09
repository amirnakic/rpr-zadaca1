package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "C8");
             System.out.println("nije");
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
