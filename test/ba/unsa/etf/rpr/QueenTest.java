package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void move() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(() -> {
            q.move("d5");
            q.move("d4");
            q.move("h4");
            q.move("a4");
            q.move("c6");
            q.move("b5");
        });
    }

    @Test
    void moveIllegal() {
        Queen q = new Queen("d8", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class, () -> q.move("h7"));
    }

}