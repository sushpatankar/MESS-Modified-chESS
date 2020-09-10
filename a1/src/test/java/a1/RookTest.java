package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private ChessBoard board;

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }
    @Test
    void testLegalMoves() throws IllegalPositionException, IllegalMoveException {
        board.initialize();
        board.move("a2", "a4");
        assertTrue(board.getPiece("a1").legalMoves().containsAll(Arrays.asList("a2","a3")));
    }


    @Test
    public void testRookSameColor() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertFalse(board.getPiece("h8").legalMoves().contains("h7"));
    }

    @Test
    public void testRook() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertTrue(board.getPiece("a8").legalMoves().size() == 0);
    }

    @Test
    public void testRookMoveHorizontally() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("b2", "b4");
        assertThrows(IllegalMoveException.class,() -> {board.move("a1", "a2");});
    }


}