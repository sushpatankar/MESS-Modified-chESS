package a1;
import java.util.ArrayList;

public class King extends ChessPiece {
    public King(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getColor()==Color.BLACK ? "\u265A" : "\u2654" ;	}

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
    public ArrayList<String> legalMoves() throws IllegalPositionException {

        // TODO Auto-generated method stub

        int x = getRow();
        int y = getCol();
        ArrayList<String> legalMove = new ArrayList<String>();
        if( x - 1 >= 0 ) {
            if( y - 1 >= 0 && ( board.getPiece(con(x - 1, y - 1 ) ) == null ||
                    this.getColor() != board.getPiece(con(x - 1, y - 1 ) ).getColor() ) ) {
                legalMove.add(con(x - 1, y - 1 ));
            }
            if( y + 1 < 8 && ( board.getPiece(con(x - 1, y + 1 ) ) == null ||
                    this.getColor() != board.getPiece(con(x - 1, y + 1 ) ).getColor() ) ) {
                legalMove.add(con(x - 1, y + 1 ));
            }
            if( ( board.getPiece(con(x - 1, y ) ) == null ) ||
                    this.getColor() != board.getPiece(con(x - 1, y ) ).getColor() ) {
                legalMove.add(con(x - 1, y ));
            }

        }
        if( y - 1 >= 0 && ( board.getPiece(con(x, y - 1 )) == null || this.getColor() != board.getPiece(con(x, y - 1 )).getColor() ) ) {
            legalMove.add(con(x, y - 1 ));
        }
        if( y + 1 < 8 && ( board.getPiece(con(x, y + 1 )) == null || this.getColor() != board.getPiece(con(x, y + 1 )).getColor() ) ) {
            legalMove.add(con(x, y + 1 ));
        }
        if( x + 1 < 8 ) {
            if( y + 1 < 8 && ( board.getPiece(con(x + 1, y + 1 ) ) == null ||
                    this.getColor() != board.getPiece(con(x + 1, y + 1 ) ).getColor() )) {
                legalMove.add(con(x + 1, y + 1 ));
            }
            if( y - 1 >= 0 && ( board.getPiece(con(x + 1, y - 1 ) ) == null ||
                    this.getColor() != board.getPiece(con(x + 1, y - 1 ) ).getColor() ) ) {
                legalMove.add(con(x + 1, y - 1 ));
            }
            if( ( board.getPiece(con(x + 1, y ) ) == null ) ||
                    this.getColor() != board.getPiece(con(x + 1, y ) ).getColor() ) {
                legalMove.add(con(x + 1, y ));
            }
        }
        return legalMove;
    }
}
