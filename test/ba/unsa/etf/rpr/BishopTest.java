package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void move() {
        Bishop b = new Bishop("c1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(() -> b.move("h6"));
    }

    @Test
    void moveIllegal() {
        Bishop b = new Bishop("c8", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class, () -> b.move("c1"));
    }

}