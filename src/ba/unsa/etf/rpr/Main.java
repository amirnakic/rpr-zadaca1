package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             System.out.println("nije");
             b.move(Pawn.class, ChessPiece.Color.WHITE, "d4");
             System.out.println("nije");
             b.move(Bishop.class, ChessPiece.Color.WHITE, "e3");
             System.out.println("nije");
             b.move(Bishop.class, ChessPiece.Color.WHITE, "b6");
             System.out.println("nije");
             b.move(Bishop.class, ChessPiece.Color.WHITE, "c7");
             System.out.println("nije");
             b.move(Bishop.class, ChessPiece.Color.WHITE, "b8");
             System.out.println("nije");
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
