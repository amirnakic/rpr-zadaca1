package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    private String position;
    private Color color;

    public static enum Color {
        BLACK, WHITE
    }

    public ChessPiece(String position, Color color) throws IllegalArgumentException {
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
        if (!this.checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else this.position = position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean checkPosition(String position) {
        if ((position.isEmpty()) || (position.length() != 2))
            return false;
        char prviZnak = position.charAt(0);
        char drugiZnak = position.charAt(1);
        if (Character.isWhitespace(prviZnak) || Character.isWhitespace(drugiZnak))
            return false;
        else if (Character.isLetter(drugiZnak) || Character.isDigit(prviZnak))
            return false;
        else if (("ABCDEFGHabcdefgh".indexOf(prviZnak) == -1) || ("12345678".indexOf(drugiZnak) == -1))
            return false;
        return true;
    }

    public abstract void move(String position);
}
