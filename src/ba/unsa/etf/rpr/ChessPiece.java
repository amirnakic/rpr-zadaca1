package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    private String position;

    public static enum Color {
        BLACK, WHITE
    }

    public abstract String getPosition();

    public abstract Color getColor();
    
}
