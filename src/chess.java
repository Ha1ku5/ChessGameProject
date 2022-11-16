import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
import static java.lang.Character.toLowerCase;

/*
TODO:
-verify that a player only moves their own piece, put in doMove method
-verify that a player does not move a piece to a square that is occupied by their own piece, put in doMove method
-
 */
public class chess {
    public static char[][] board = new char[8][8];
    public static String avaLetters = "abcdefgh";
    public static String avaNumbers = "12345678";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type 'play' to begin a game, 'help' for help, or 'quit' to exit\n");
        menu();


    }

        /*
        ask for move DONE
        translate text to numbers
        check if valid
        move location of piece
        */
    public static void doMove(String move){
        String to = move.substring(3);
        String from = move.substring(0,2);
        int toX = avaLetters.indexOf(to.charAt(0));
        int toY = avaNumbers.indexOf(to.charAt(1));
        int fromX = avaLetters.indexOf(from.charAt(0));
        int fromY = avaNumbers.indexOf(from.charAt(1));

        char piece = board[fromY][fromX];
        piece = toLowerCase(piece);
        switch(piece){ //ASSUMES THEY ONLY TRY AND MOVE THEIR OWN PIECES - NEEDS TO BE FIXED
            case 'P':
                if(toY == fromY + 1 && toX == fromX){
                    board[toY][toX] = piece;
                    board[fromY][fromX] = ' ';
                }
                break;
            case 'p':
                if(toY == fromY - 1 && toX == fromX){
                    board[toY][toX] = piece;
                    board[fromY][fromX] = ' ';
                }



        }

        System.out.println(toX + " " + toY + " " + fromX + " " + fromY);


    }
    public static void play(){
        Scanner in = new Scanner(System.in);

        boolean run = true;
        boolean wMove = true;
        boolean bMove = true;
        while(run) {

            //white's move
            while(wMove) {
                System.out.print("White's move\n>");
                String whiteMove = in.nextLine();
                if (whiteMove.equalsIgnoreCase("forfeit") || whiteMove.equalsIgnoreCase("ff")) { //game over
                    System.out.println("White forfeits, Black wins!");
                    resetBoard();
                    menu();
                }
                if (!validate(whiteMove)) {
                    System.out.println("Invalid move! \n Try again");
                    play();
                } else {
                    doMove(whiteMove);
                    wMove = false;
                }
            }

            //black's move
            while(bMove) {
                System.out.print("Black's move\n>");
                String blackMove = in.nextLine();
                if (blackMove.equalsIgnoreCase("forfeit") || blackMove.equalsIgnoreCase("ff")) { //game over
                    System.out.println("Black forfeits, White wins!");
                    resetBoard();
                    menu();
                }
                if (!validate(blackMove)) {
                    System.out.println("Invalid move! \n Try again");
                    play();
                } else {
                    doMove(blackMove);
                    bMove = false;
                }
            }



        }
    }



    //makes sure that the input is in bounds
    //possibly the ugliest method I've ever written
    public static boolean validate(String checkMe){//concatenating string w char makes .contains() work on char
        return (avaNumbers.contains(checkMe.charAt(1) + "")) && (avaNumbers.contains(checkMe.charAt(4) + "")) &&
                ((avaLetters.contains(checkMe.charAt(0) + "")) && (avaLetters.contains(checkMe.charAt(3) + "")));
    }

    public static void menu(){
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        String input = in.nextLine();
        switch (input){
            case "help":
                help();
                break;
            case "quit":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case "play":
                play();
                break;
            default:
                System.out.println("Invalid argument, please try again.");
                menu();
        }
    }
    //looks garbage, will fix later
    public static void printBoard(){
        int[] label = {8,7,6,5,4,3,2,1};
        //prints out current board state

        System.out.print("   ");
        System.out.print("\033[4m");
        System.out.println(" A  B  C  D  E  F  G  H ");
        System.out.print("\033[0m");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d  ", label[i]);
            System.out.println(Arrays.toString(board[i]));

        }

    }
    //help menu
    public static void help(){
        System.out.println("Type the coordinates of the piece you want to move");
        System.out.println("Then type the coordinates of where you want to move it");
        System.out.println("Example: 'a2 a4' moves the piece at a2 to a4");
        System.out.println("Lowercase pieces are white, uppercase are black");
        System.out.println("At any point if you wish to resign type 'forfeit' or 'ff'");
        menu();
    }

    //sets board to default state
    public static void resetBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ' ';
            }
        }
        board[0][0] = 'R';
        board[0][1] = 'N';
        board[0][2] = 'B';
        board[0][3] = 'Q';
        board[0][4] = 'K';
        board[0][5] = 'B';
        board[0][6] = 'N';
        board[0][7] = 'R';
        board[1][0] = 'P';
        board[1][1] = 'P';
        board[1][2] = 'P';
        board[1][3] = 'P';
        board[1][4] = 'P';
        board[1][5] = 'P';
        board[1][6] = 'P';
        board[1][7] = 'P';
        board[6][0] = 'p';
        board[6][1] = 'p';
        board[6][2] = 'p';
        board[6][3] = 'p';
        board[6][4] = 'p';
        board[6][5] = 'p';
        board[6][6] = 'p';
        board[6][7] = 'p';
        board[7][0] = 'r';
        board[7][1] = 'n';
        board[7][2] = 'b';
        board[7][3] = 'q';
        board[7][4] = 'k';
        board[7][5] = 'b';
        board[7][6] = 'n';
        board[7][7] = 'r';
    }
}