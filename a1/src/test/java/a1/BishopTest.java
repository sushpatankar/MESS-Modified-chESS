package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopTest {

    private ChessBoard board;

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }

    @Test
    public void testLegalMoves() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("c1", "a3");
        assertTrue(board.getPiece("c1").legalMoves().containsAll(Arrays.asList("b2","a3")));
        board.move("a3", "c5");
        assertTrue(board.getPiece("a3").legalMoves().containsAll(Arrays.asList("b4","c5")));

    }

    @Test
    public void testBishopAtStart() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertTrue(board.getPiece("f8").legalMoves().size() == 0);
    }

    @Test
    public void testBishopWillNotMoveVertically() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertThrows(IllegalMoveException.class,() -> {board.move("f8", "f6");});
    }

    @Test
    public void testBishopWillNotMoveHorizontally() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertThrows(IllegalMoveException.class,() -> {board.move("f1", "e1");});
    }



}