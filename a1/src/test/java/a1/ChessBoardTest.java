package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    ChessBoard board;

    @BeforeEach
    void initialize() {
        board=new ChessBoard();
    }

    @Test
    public void boardPiecesPlacedCorrectly() throws IllegalPositionException
    {
        board.initialize();
        assertEquals("\u265E", board.getPiece("b8").toString(), "Knight(Black) not present at b8");
        assertEquals("\u265C", board.getPiece("a8").toString(), "Rook(Black) not present at a8");
        assertEquals("\u2656", board.getPiece("h1").toString(), "Rook not present at h1");
        assertEquals("\u2658", board.getPiece("g1").toString(), "Knight not present at g1");
    }

    @Test
    public void testGetPieceInvalidPosition() throws IllegalPositionException {
        assertThrows(IllegalPositionException.class, () -> { board.getPiece("q9");});
        assertThrows(IllegalPositionException.class, () -> { board.getPiece("j9");});
    }

    @Test
    public void testGetPieceRetPie() throws IllegalPositionException, IllegalMoveException {
        board.initialize();
        board.move("b2", "b4");
        assertEquals("\u2659",board.getPiece("b4").toString());
        board.move("c1", "a3");
        assertEquals("\u2657",board.getPiece("a3").toString());
    }

    @Test
    public void testColorIsSame() throws IllegalPositionException {

        board.initialize();
        board.placePiece(board.getPiece("b2"), "b4");
        assertFalse(board.placePiece(board.getPiece("b1"), "b4"));
    }

}