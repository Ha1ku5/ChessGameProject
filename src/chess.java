import java.util.Arrays;

public class chess {
    public static char[][] board = new char[8][8];


    public static void main(String[] args) {
        /*
        ask for move
        translate text to numbers
        check if valid
        move location of piece

        */


        board[2][3] = 'c';
        System.out.println("Where do you want to move? (a4 a6)");
        resetBoard();
        printBoard();

    }


    public static void resetBoard() {
        //places pawns
        for(int i = 0; i < board[1].length; i++ ){
            board[1][i] = 'p';
            board[6][i] = 'p';
        }
    }

    public static void printBoard(){
        //prints out board like chess board
        System.out.println("  a  b  c  d  e  f  g  h ");
        System.out.println("  -  -  -  -  -  -  -  -");

        for(int i = 0; i < board.length; i++){
            
            for(int j = 0; j < board[i].length; j++){
                System.out.printf("%c  ", board[i][j]);
            }
            System.out.println();
        }


    }
}