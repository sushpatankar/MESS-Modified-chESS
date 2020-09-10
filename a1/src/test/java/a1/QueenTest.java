package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {
    private ChessBoard board;

    @Test
    void testLegalMoves() throws IllegalPositionException, IllegalMoveException {
        board.initialize();
        board.move("d2", "d4");
        board.move("c1", "f4");
        assertTrue(board.getPiece("d1").legalMoves().size() == 0);

    }

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }


    @Test
    public void testQueen() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertEquals("\u2655", board.getPiece("d1").toString(), "White Queen not returned");
    }

}