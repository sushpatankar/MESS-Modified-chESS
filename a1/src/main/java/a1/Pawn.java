package a1;
import java.util.ArrayList;

public class Pawn extends ChessPiece{
    public Pawn(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    private String con(int row ,int col) {
        String intTostr = "";

        switch(col) {
            case 0:
                intTostr = intTostr+ "a" ;
                break;
            case 1:
                intTostr = intTostr+ "b";
                break;
            case 2:
                intTostr = intTostr+ "c";
                break;
            case 3:
                intTostr = intTostr+ "d";
                break;
            case 4:
                intTostr = intTostr+ "e";
                break;
            case 5:
                intTostr = intTostr+ "f";
                break;
            case 6:
                intTostr = intTostr+ "g";
                break;
            case 7:
                intTostr = intTostr+ "h";
                break;
            default:
                break;
        }
        switch(row) {
            case 0:
                intTostr = intTostr+  "1";
                break;
            case 1:
                intTostr = intTostr +  "2";
                break;
            case 2:
                intTostr = intTostr+ "3";
                break;
            case 3:
                intTostr = intTostr+ "4";
                break;
            case 4:
                intTostr = intTostr+ "5";
                break;
            case 5:
                intTostr = intTostr+ "6";
                break;
            case 6:
                intTostr = intTostr+ "7";
                break;
            case 7:
                intTostr = intTostr+ "8";
                break;
            default:
                break;
        }
        return intTostr;
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub

        return this.getColor()==Color.BLACK ? "\u265F" : "\u2659" ;
    }

    @Override
    public ArrayList<String> legalMoves() throws IllegalPositionException {
        // TODO Auto-generated method stub
        ArrayList<String> legalMove = new ArrayList<String>();
        int x =getRow();
        int y = getCol();

        //System.out.println("Test"+getColor()+"Hey"+Color.WHITE);
        if(this.getColor()== Color.WHITE) {
            if(x==1) {
                if(board.getPiece(con(x+1, y))== null) {
                    legalMove.add(con(x+1, y));
                }
                if(board.getPiece(con(x+2, y))== null) {
                    legalMove.add(con(x+2, y));
                }
                if((x+1)<8 && (y+1)<8 && board.getPiece(con(x+1, y+1))!= null);
                {
                    legalMove.add(con(x+1, y+1));
                }
                if(board.getPiece(con(x+1, y)) != null && board.getPiece(con(x+1, y)).getColor()!=Color.WHITE){
                    legalMove.add(con(x+1, y));
                }
                if((x<8) && (y+1)<8  && board.getPiece(con(x + 1, y + 1)) != null) {
                    if(!legalMove.contains( con(x + 1, y))){
                        legalMove.add(con(x+1,y));
                    }
                }
            }
        }
        else if(this.getColor()== Color.BLACK) {
            if(x==6) {
                if(board.getPiece(con(x-1, y))== null) {
                    legalMove.add(con(x-1, y));
                }
                if(board.getPiece(con(x-2, y))== null) {
                    legalMove.add(con(x-2, y));
                }
                if((x+1)<8 && (y+1)<8 && board.getPiece(con(x-1, y-1))!= null);
                {
                    legalMove.add(con(x-1, y-1));
                }
                if(board.getPiece(con(x-1, y-1)) != null && board.getPiece(con(x-1, y-1)).getColor()!=Color.BLACK){
                    legalMove.add(con(x-1, y-1));
                }
                if((x<8) && (y-1)<8  && board.getPiece(con(x - 1, y - 1)) != null) {
                    if(!legalMove.contains( con(x - 1, y))){
                        legalMove.add(con(x-1,y));
                    }
                }
            }
        }

        return legalMove;
    }
}
