package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             b.move(Pawn.class, ChessPiece.Color.WHITE, "d4");
             b.move(Queen.class, ChessPiece.Color.WHITE, "d3");
             b.move(Queen.class, ChessPiece.Color.WHITE, "h3");
             b.move(Queen.class, ChessPiece.Color.WHITE, "h7");
             b.move(Queen.class, ChessPiece.Color.WHITE, "f7");
             b.move(Queen.class, ChessPiece.Color.WHITE, "b3");
             b.move(Queen.class, ChessPiece.Color.WHITE, "b7");
             System.out.println(b.getActiveFigures().size());

         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
