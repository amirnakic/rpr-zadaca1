package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    private String position;
    private Color color;

    public static enum Color {
        BLACK, WHITE
    }

    public ChessPiece(String position, ChessPiece.Color color) throws IllegalArgumentException {
        this.setPosition(position);
        this.setColor(color);
    }

    public String getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(String position) throws IllegalArgumentException {
        if (!this.checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else this.position = position.toUpperCase();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean checkPosition(String position) {
        if (position.length() != 2) return false;
        char first = position.charAt(0);
        char second = position.charAt(1);
        if (("ABCDEFGHabcdefgh".indexOf(first) == -1) || ("12345678".indexOf(second) == -1))
            return false;
        return true;
    }

    public abstract void move(String position) throws IllegalArgumentException, IllegalChessMoveException;
}
