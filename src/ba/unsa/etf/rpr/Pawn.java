package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String position, ChessPiece.Color color) {
        super(position, color);
    }

    //zbog specificnosti pjesaka, proces jedenja druge figure ne mozemo realizirati preko metode move pa je zato tu ova metoda
    public void eat(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else if (!isPawnsDiagonalMoveCorrect(position)) throw new IllegalChessMoveException("Illegal move.");
        else setPosition(position);
    }

    //pjesak se krece dijagonalno prema naprijed za jedno polje kada njime zelimo pojesti drugu figuru
    public boolean isPawnsDiagonalMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = currentPosition.charAt(0) - position.charAt(0);
        int result2 = (currentPosition.charAt(1) - '0') - (position.charAt(1) - '0');
        if (getColor() == Color.WHITE) {
            if (result1 == -1 && result2 == -1)
                return true;
            else if (result1 == 1 && result2 == -1)
                return true;
        } else {
            if (result1 == 1 && result2 == 1)
                return true;
            else if (result1 == -1 && result2 == 1)
                return true;
        }
        return false;
    }

    //pjesak se krece iskljucivo prema naprijed, i to za dva polja iz pocetne pozicije, odnosno jedno iz bilo koje druge
    public boolean isPawnsVerticalMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = currentPosition.charAt(0) - position.charAt(0);
        int result2 = (currentPosition.charAt(1) - '0') - (position.charAt(1) - '0');
        if (getColor() == Color.WHITE) {
            if (result1 == 0 && result2 == -1)
                return true;
            else if ((currentPosition.charAt(1) - '0') == 2 && result1 == 0 && result2 == -2)
                return true;
        } else {
            if (result1 == 0 && result2 == 1)
                return true;
            else if ((currentPosition.charAt(1) - '0') == 7 && result1 == 0 && result2 == 2)
                return true;
        }
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Illegal move.");
        else if (!isPawnsVerticalMoveCorrect(position)) throw new IllegalChessMoveException("Illegal move.");
        else setPosition(position);
    }
}
