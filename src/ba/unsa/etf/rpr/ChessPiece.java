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
        if (!this.checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else this.position = position.toUpperCase();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean checkPosition(String position) {
        if ((position.isEmpty()) || (position.length() != 2))
            return false;
        char first = position.charAt(0);
        char second = position.charAt(1);
        if (Character.isWhitespace(first) || Character.isWhitespace(second))
            return false;
        else if (Character.isLetter(second) || Character.isDigit(first))
            return false;
        else if (("ABCDEFGHabcdefgh".indexOf(first) == -1) || ("12345678".indexOf(second) == -1))
            return false;
        return true;
    }

    public abstract void move(String position) throws IllegalArgumentException, IllegalChessMoveException;

    @Override
    public boolean equals(Object o) {
        ChessPiece figure = (ChessPiece) o;
        if (figure.getPosition().equals(((ChessPiece) o).getPosition()) && figure.getColor() == ((ChessPiece) o).getColor())
            return true;
        return false;
    }
}
