package a1;

import a1.ChessPiece.Color;

import java.util.ArrayList;

public class ChessBoard {
    private ChessPiece [][] board;

    public ChessBoard() {
        // TODO Auto-generated constructor stub
        this.board = new ChessPiece [8][8];
        for (int i =0;i<8;i++) {
            for(int j =0;j<8;j++) {
                board[i][j]=null;
            }
        }
    }

    public void initialize() throws IllegalPositionException {
        // White Pawns
        placePiece(new Pawn(this, Color.WHITE), "a2");
        placePiece(new Pawn(this, Color.WHITE), "b2");
        placePiece(new Pawn(this, Color.WHITE), "c2");
        placePiece(new Pawn(this, Color.WHITE), "d2");
        placePiece(new Pawn(this, Color.WHITE), "e2");
        placePiece(new Pawn(this, Color.WHITE), "f2");
        placePiece(new Pawn(this, Color.WHITE), "g2");
        placePiece(new Pawn(this, Color.WHITE), "h2");
        // White Pieces
        placePiece(new Rook(this, Color.WHITE), "a1");
        placePiece(new Rook(this, Color.WHITE), "h1");
        placePiece(new Bishop(this, Color.WHITE), "c1");
        placePiece(new Bishop(this, Color.WHITE), "f1");
        placePiece(new Knight(this, Color.WHITE), "g1");
        placePiece(new Knight(this, Color.WHITE), "b1");
        placePiece(new Queen(this, Color.WHITE), "d1");
        placePiece(new King(this, Color.WHITE), "e1");
        //Black Piece
        placePiece(new Rook(this, Color.BLACK), "a8");
        placePiece(new Rook(this, Color.BLACK), "h8");
        placePiece(new Bishop(this, Color.BLACK), "c8");
        placePiece(new Bishop(this, Color.BLACK), "f8");
        placePiece(new Knight(this, Color.BLACK), "g8");
        placePiece(new Knight(this, Color.BLACK), "b8");
        placePiece(new Queen(this, Color.BLACK), "d8");
        placePiece(new King(this, Color.BLACK), "e8");
        //Black Pawns
        placePiece(new Pawn(this, Color.BLACK), "a7");
        placePiece(new Pawn(this, Color.BLACK), "b7");
        placePiece(new Pawn(this, Color.BLACK), "c7");
        placePiece(new Pawn(this, Color.BLACK), "d7");
        placePiece(new Pawn(this, Color.BLACK), "e7");
        placePiece(new Pawn(this, Color.BLACK), "f7");
        placePiece(new Pawn(this, Color.BLACK), "g7");
        placePiece(new Pawn(this, Color.BLACK), "h7");



    }

    public String toString(){
        String chess="";
        String upperLeft = "\u250C";
        String upperRight = "\u2510";
        String horizontalLine = "\u2500";
        String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
        String verticalLine = "\u2502";
        String upperT = "\u252C";
        String bottomLeft = "\u2514";
        String bottomRight = "\u2518";
        String bottomT = "\u2534";
        String plus = "\u253C";
        String leftT = "\u251C";
        String rightT = "\u2524";

        String topLine = upperLeft;
        for (int i = 0; i<7; i++){
            topLine += horizontal3 + upperT;
        }
        topLine += horizontal3 + upperRight;

        String bottomLine = bottomLeft;
        for (int i = 0; i<7; i++){
            bottomLine += horizontal3 + bottomT;
        }
        bottomLine += horizontal3 + bottomRight;
        chess+=topLine + "\n";

        for (int row = 7; row >=0; row--){
            String midLine = "";
            for (int col = 0; col < 8; col++){
                if(board[row][col]==null) {
                    midLine += verticalLine + " \u3000 ";
                } else {midLine += verticalLine + " "+board[row][col]+" ";}
            }
            midLine += verticalLine;
            String midLine2 = leftT;
            for (int i = 0; i<7; i++){
                midLine2 += horizontal3 + plus;
            }
            midLine2 += horizontal3 + rightT;
            chess+=midLine+ "\n";
            if(row>=1)
                chess+=midLine2+ "\n";
        }

        chess+=bottomLine;
        return chess;
    }

    private int strtoint(char c) {

        switch(c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return -1;
        }

    }



    public ChessPiece getPiece(String position) throws IllegalPositionException{
        if(StrValid(position)) {
            return board[Character.getNumericValue(position.charAt(1))-1][strtoint(position.charAt(0))];
        }
        else
            throw new IllegalPositionException();

    }



    public boolean placePiece(ChessPiece piece, String position) throws IllegalPositionException{
        if((StrValid(position))) {
            ChessPiece curr = this.getPiece(position);
            if(curr!= null && curr.getColor()!=piece.getColor()) {
                board[Character.getNumericValue(position.charAt(1))-1][strtoint(position.charAt(0))]=piece;


            }
            else if(curr==null){
                board[Character.getNumericValue(position.charAt(1))-1][strtoint(position.charAt(0))]=piece;}
            piece.setPosition(position);
        }

        return false;
    }

    public void move(String fromPosition, String toPosition) throws IllegalMoveException, IllegalPositionException{
        ChessPiece piece = getPiece(fromPosition);
        ArrayList<String> legalMove = piece.legalMoves();
        if(legalMove.contains(toPosition)) {
            int row = Character.getNumericValue(fromPosition.charAt(1))-1;
            int col = strtoint(fromPosition.charAt(0));

            placePiece(piece, toPosition);
            board[row][col]=null;
        }
        else {
            throw new IllegalMoveException();
        }

    }

    public boolean StrValid(String pos) {
        int x = strtoint(pos.charAt(0));
        int y = Integer.parseInt(String.valueOf(pos.charAt(1))) - 1;
        if(x < 0 || x > 7 || y < 0 || y > 7)
        {
            return false;
        }
        return true;
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

    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {
        ChessBoard board = new ChessBoard();
        board.initialize();
        System.out.println(board);
         board.move("c2", "c4");
         System.out.println(board);
        // board.move("b2", "b3");
        // System.out.println(board);
        // board.move("b3", "c4");
//        System.out.println(board);
//
//        board.move("h2", "h4");
//        System.out.println(board);
//
//
//
//        board.move("h1", "h3"); System.out.println(board);

        /*
         * board.move("e2", "e4"); System.out.println(board); board.move("d2", "d3");
         * System.out.println(board); board.move("e1", "d2"); System.out.println(board);
         */
    }

}
