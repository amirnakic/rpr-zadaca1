package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String position, ChessPiece.Color color) {
        super(position, color);
    }

    public boolean isPawnsMoveCorrect(String position) {
        String currentPosition = getPosition();
        position = position.toUpperCase();
        int rezultat1 = currentPosition.charAt(0) - position.charAt(0);
        int rezultat2 = (currentPosition.charAt(1) - '0') - (position.charAt(1) - '0');
        if (rezultat1 == 0 && rezultat2 == -1)
            return true; //iz bilo koje druge pozicije osim pocetne, pjeska se moze pomjerati samo za jedno mjesto iskljucivo prema naprijed
        else if ((currentPosition.charAt(1) - '0') == 2 && rezultat1 == 0 && rezultat2 == -2)
            return true; //iz pocetne pozicije pjesak moze da se pomjeri za dva mjesta iskljucivo prema naprijed
        return false;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (!checkPosition(position)) throw new IllegalArgumentException("Parameter is incorrect.");
        else if (!isPawnsMoveCorrect(position)) throw new IllegalChessMoveException("Parameter is incorrect.");
        else setPosition(position);
    }
}
