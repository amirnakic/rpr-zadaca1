package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @Test
    void move2() {
        Pawn p = new Pawn("E5", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class, () -> p.move("E6"));
    }

    @Test
    void eat1() {
        Pawn p = new Pawn("d2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(() -> p.eat("e3"));
    }

    @Test
    void eat2() {
        Pawn p = new Pawn("d7", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class, () -> p.eat("F5"));
    }
}