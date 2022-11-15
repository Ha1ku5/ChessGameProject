import java.util.Arrays;
import java.util.Scanner;

public class chess {
    public static char[][] board = new char[8][8];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type 'play' to begin a game, 'help' for help, or 'quit' to exit\n");
        inputLoop();
        play();

    }
        /*
        ask for move DONE
        translate text to numbers
        check if valid
        move location of piece
        */
    public static void play(){






    }

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
    public static void inputLoop(){
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
                break;
            default:
                System.out.println("Invalid argument, please try again.");
                inputLoop();
        }
    }
    //help menu
    public static void help(){
        System.out.println("Type the coordinates of the piece you want to move");
        System.out.println("Then type the coordinates of where you want to move it");
        System.out.println("Example: 'a2 a4' moves the piece at a2 to a4");
        System.out.println("Lowercase pieces are white, uppercase are black");
        inputLoop();
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