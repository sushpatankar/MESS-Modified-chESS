package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private ChessBoard board;

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }

    @Test
    public void testLegalMoves() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("e7", "e5");
        assertTrue(board.getPiece("e8").legalMoves().containsAll(Arrays.asList("e7")));
        board.move("e8", "e7");
        assertTrue(board.getPiece("e7").legalMoves().containsAll(Arrays.asList("e6", "e8", "d6", "f6")));
    }

    @Test
    public void testCaptureSameColor() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("e7", "e6");
        board.move("e8", "e7");
        assertFalse(board.getPiece("e7").legalMoves().contains("e6"));
    }

    @Test
    public void testMoveOneSquare() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("e2", "e4");
        assertThrows(IllegalMoveException.class, () -> {board.move("e1", "e3");});
    }

    @Test
    public void testKingKillEnemyPiece() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("e7", "e5");
        board.move("d3", "d4");
        board.move("d4", "d5");
        board.move("e8", "e7");
        board.move("e7", "e6");
        assertTrue(board.getPiece("e6").legalMoves().containsAll(Arrays.asList("e5", "d5", "f5", "d4","d6", "f6")));
    }
}