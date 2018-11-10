package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }

    @Test
    void move1() {
        Knight k = new Knight("b2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class, () -> k.move("a5"));
    }
}