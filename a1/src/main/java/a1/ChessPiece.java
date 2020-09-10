package a1;

import java.util.*;

public abstract class ChessPiece {
    public enum Color {WHITE, BLACK};

    protected int row;
    protected int column;
    protected Color color;
    protected ChessBoard board;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return column;
    }

    public void setCol(int col) {
        this.column = col;
    }


    public ChessPiece(ChessBoard board, Color color) {
        // TODO Auto-generated constructor stub
        this.board = board;
        this.color = color;
    }

    public Color getColor() {
        return color;

    }

    public String getPosition() {
        return con(row, column);
    }

    public void setPosition(String position) throws IllegalPositionException {

        if (valid(position)) {
            column = strtoint(position.charAt(0));
            row = Character.getNumericValue(position.charAt(1)) - 1;
        } else {
            throw new IllegalPositionException();
        }
    }

    private String con(int row, int col) {
        String intTostr = "";

        switch (col) {
            case 0:
                intTostr = intTostr + "a";
                break;
            case 1:
                intTostr = intTostr + "b";
                break;
            case 2:
                intTostr = intTostr + "c";
                break;
            case 3:
                intTostr = intTostr + "d";
                break;
            case 4:
                intTostr = intTostr + "e";
                break;
            case 5:
                intTostr = intTostr + "f";
                break;
            case 6:
                intTostr = intTostr + "g";
                break;
            case 7:
                intTostr = intTostr + "h";
                break;
            default:
                break;
        }
        switch (row) {
            case 0:
                intTostr = intTostr + "1";
                break;
            case 1:
                intTostr = intTostr + "2";
                break;
            case 2:
                intTostr = intTostr + "3";
                break;
            case 3:
                intTostr = intTostr + "4";
                break;
            case 4:
                intTostr = intTostr + "5";
                break;
            case 5:
                intTostr = intTostr + "6";
                break;
            case 6:
                intTostr = intTostr + "7";
                break;
            case 7:
                intTostr = intTostr + "8";
                break;
            default:
                break;
        }
        return intTostr;
    }


    abstract public String toString();

    public abstract ArrayList<String> legalMoves() throws IllegalPositionException;


    static public boolean valid(String pos) {

        int x = strtoint(pos.charAt(0));
        int y = Integer.parseInt(String.valueOf(pos.charAt(1))) - 1;
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        return true;
    }

    private static int strtoint(char c) {

        switch (c) {
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
}
