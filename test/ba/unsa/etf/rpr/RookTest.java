package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void move() {
        Rook r = new Rook("a8", ChessPiece.Color.BLACK);
        assertDoesNotThrow(() -> {
            r.move("a1");
            r.move("h1");
            r.move("h8");
            r.move("a8");
        });
    }

    @Test
    void moveIllegal() {
        Rook r = new Rook("a8", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class, () -> r.move("h1"));
    }

}