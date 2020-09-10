package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import java.util.Arrays;


class KnightTest {
    private ChessBoard board;

    @BeforeEach
    void initialize() {
        board = new ChessBoard();
    }

    @Test
    public void testLegalMovesKnight() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        board.move("g1", "g3");
        board.move("c1", "d4");
        board.move("c1", "d2");
        assertTrue(board.getPiece("g1").legalMoves().size() == 0);
    }

    @Test
    public void testKnight() throws IllegalMoveException, IllegalPositionException {
        board.initialize();
        assertEquals("\u2658", board.getPiece("g1").toString(), "Knight not returned");
        assertEquals("\u265E", board.getPiece("g8").toString(), "Knight(Black) not returned");

    }


}