package a1;

import org.junit.runner.JUnitCore;

public class ChessSuite {
    public  static void main(String[] args){

        JUnitCore.runClasses(ChessBoard.class);
        JUnitCore.runClasses(KingTest.class);
        JUnitCore.runClasses(QueenTest.class);
        JUnitCore.runClasses(BishopTest.class);
        JUnitCore.runClasses(KnightTest.class);
        JUnitCore.runClasses(RookTest.class);

    }
}
