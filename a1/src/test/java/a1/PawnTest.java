package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnTest {

    private ChessBoard board;

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }

    @Test
    public void testLegalMoves() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertTrue(board.getPiece("b2").legalMoves().containsAll(Arrays.asList("b3","b4")));
        board.move("c2", "c3");
        assertTrue(board.getPiece("c3").legalMoves().contains("c4"));
    }

    @Test
    public void testCaptureSameColor() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("e2","e4");
        board.move("f2","f3");
        assertFalse(board.getPiece("f3").legalMoves().contains("e4"));
    }

    @Test
    public void testPawnCapture() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("h7","h5");
        board.move("g2","g4");
        assertTrue(board.getPiece("g4").legalMoves().contains("h5"));
    }

    @Test
    public void testPawnMoveBack() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("g2","g4");
        assertFalse(board.getPiece("g4").legalMoves().contains("g3"));
    }

}