package a1;
import java.util.*;
public class Queen extends ChessPiece {

    public Queen(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getColor()==Color.BLACK ? "\u265B" : "\u2655" ;
    }


    @Override
    public ArrayList<String> legalMoves() throws IllegalPositionException {
        // TODO Auto-generated method stub
        return null;
    }




	/*
	public queen clone() {
		return new queen(color);
	}
*/




}