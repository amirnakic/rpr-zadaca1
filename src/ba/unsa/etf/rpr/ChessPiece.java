package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    protected String position;

    public static enum Color {
        BLACK, WHITE
    }

    public abstract String getPosition();

    public abstract Color getColor();

}
