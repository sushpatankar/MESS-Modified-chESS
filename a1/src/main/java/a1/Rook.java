package a1;

import  java.util.ArrayList;
public class Rook extends ChessPiece{

    public Rook(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getColor()==Color.BLACK ? "\u265C" : "\u2656" ;
    }

    private String convert(int row ,int col) {
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
    public ArrayList<String> legalMoves() throws IllegalPositionException {
        // TODO Auto-generated method stub
        ArrayList<String> legalMove = new ArrayList<String>();
        int x =getRow();
        int y = getCol();
        //up
        for(int i = x+1;i<8;i++) {
            if(board.getPiece(convert(i, y))== null ) {
                legalMove.add(convert(i, y));
            }
            else if(board.getPiece(convert(i, y)).getColor()!=color)
            {
                legalMove.add(convert(i, y));

            }
            else
                break;
        }
        //right
        for(int i = y+1;i<8;i++) {
            if(board.getPiece(convert(x, i))== null ) {
                legalMove.add(convert(x, i));
            }
            else if( board.getPiece(convert(x, i)).getColor()!=color) {
                legalMove.add(convert(x, i));

            }
            else
                break;
        }

        // Down
        for(int i = x-1;i>=0;i++) {
            if(board.getPiece(convert(i, y))== null) {
                legalMove.add(convert(i, y));
            }
            else if(board.getPiece(convert(i, y)).getColor()!=color) {
                legalMove.add(convert(i, y));

            }
            else
                break;
        }

        //left
        for(int i = y-1;i>=0;i++) {
            if(board.getPiece(convert(x, i))== null ) {
                legalMove.add(convert(x, i));
            }
            else if(board.getPiece(convert(x, i)).getColor()!=color) {
                legalMove.add(convert(x, i));
            }
            else
                break;
        }

        return legalMove;
    }

}