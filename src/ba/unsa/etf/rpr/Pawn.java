package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public void eat(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isPawnsDiagonalMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }

    public boolean isPawnsDiagonalMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = currentPosition.charAt(0) - position.charAt(0);
        int result2 = (currentPosition.charAt(1) - '0') - (position.charAt(1) - '0');
        if (getColor() == Color.WHITE) {
            if (result1 == -1 && result2 == -1) {
                return true;
            } else if (result1 == 1 && result2 == -1) {
                setPosition(position);
                return true;
            }
        } else {
            if (result1 == 1 && result2 == 1) {
                setPosition(position);
                return true;
            } else if (result1 == -1 && result2 == 1) {
                setPosition(position);
                return true;
            }
        }
        return false;
    }

    public boolean isPawnsVerticalMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int result1 = currentPosition.charAt(0) - position.charAt(0);
        int result2 = (currentPosition.charAt(1) - '0') - (position.charAt(1) - '0');
        if (getColor() == Color.WHITE) {
            if (result1 == 0 && result2 == -1)
                return true; //iz bilo koje druge pozicije osim pocetne, pjeska se moze pomjerati samo za jedno mjesto iskljucivo prema naprijed
            else if ((currentPosition.charAt(1) - '0') == 2 && result1 == 0 && result2 == -2)
                return true; //iz pocetne pozicije pjesak moze da se pomjeri za dva mjesta iskljucivo prema naprijed
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
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isPawnsVerticalMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
