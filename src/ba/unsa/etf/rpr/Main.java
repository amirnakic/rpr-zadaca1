package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             b.move(Pawn.class, ChessPiece.Color.WHITE, "e4");
             b.move(Knight.class, ChessPiece.Color.WHITE, "c3");
             b.move(Knight.class, ChessPiece.Color.WHITE, "d5");
             b.move(Knight.class, ChessPiece.Color.WHITE, "e7");
             b.move(Knight.class, ChessPiece.Color.WHITE, "g8");
             b.move(King.class, ChessPiece.Color.WHITE, "e2");
             b.move(King.class, ChessPiece.Color.WHITE, "f3");
             System.out.println(b.getActiveFigures().size());

         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
