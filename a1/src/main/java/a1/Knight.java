package a1;

import  java.util.ArrayList;
public class Knight extends ChessPiece {

    public Knight(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getColor()==Color.BLACK ? "\u265E" : "\u2658" ;
    }

    @Override
    public ArrayList<String> legalMoves() throws IllegalPositionException {
        // TODO Auto-generated method stub
        return null;
    }

}