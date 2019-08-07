package tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Overview: Main driver class for Tictactoe.
//In order to play, user inputs "human", "bot" or "random" after which the game starts and the user can begin placing their X and/or O on the playing board.
public class TicTacToe {

    //Requires: None
    //Modifies: Tic tac toe board
    //Effects: End result is either win, lose or draw.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Scanner inp2 = new Scanner(System.in);

        System.out.println("Enter Player 1 full name");
        String fullName = scanner.nextLine();
        if (!validName(fullName)) {
            System.exit(0);
        }

        System.out.println("Enter 1st player: human, bot or random");
        String inp1 = scanner.nextLine();

        System.out.println("Enter Player 2 full name");
        String fullName2 = scanner.nextLine();
        if (!validName(fullName2)) {
            System.exit(0);
        }

        System.out.println("Enter 2nd player: human, bot or random");
        String inp2 = scanner.nextLine();

        Player playerX = null;
        Player playerO = null;

        //set player X
        if (inp1.equalsIgnoreCase("human")) {
            playerX = new HumanPlayer(fullName);
        } else if (inp1.equalsIgnoreCase("bot")) {
            playerX = new EasyBotPlayer(fullName);
        } else if (inp1.equalsIgnoreCase("random")) {
            playerX = new RandomBotPlayer(fullName);
        } else {
            System.out.println("You must enter one of the following: human, naive bot, or random bot");
            System.exit(0);
        }

        //set player O
        if (inp2.equalsIgnoreCase("human")) {
            playerO = new HumanPlayer(fullName2);
        } else if (inp2.equalsIgnoreCase("bot")) {
            playerO = new EasyBotPlayer(fullName2);
        } else if (inp2.equalsIgnoreCase("random")) {
            playerO = new RandomBotPlayer(fullName2);
        } else {
            System.out.println("You must enter one of the following: human, naive bot, or random bot. Program exiting.");
            System.exit(0);
        }

        System.out.println("\nTic-Tac-Toe!\n\n"
                + "1|2|3\n"
                + "-----\n"
                + "4|5|6\n"
                + "-----\n"
                + "7|8|9\n");

        TicTacToeBoard board = new TicTacToeBoard();

        int compMove;
        while (!(board.xWins() || board.oWins() || board.draw())) {
            //Player "X" plays
            if (TicTacToeBoard.isPlayerX()) {

                playerX.promptInput();

                if (inp1.equalsIgnoreCase("human")) {
                    board.turn(playerX.makeMove());
                } else {
                    compMove = playerX.makeMove();
                    System.out.println(compMove);
                    board.turn(compMove);
                }
            } else {

                //Player "O" plays
                playerO.promptInput();

                if (inp2.equalsIgnoreCase("human")) {
                    board.turn(playerO.makeMove());
                } else {
                    compMove = playerO.makeMove();
                    System.out.println(compMove);
                    board.turn(compMove);
                }
            }

            board.displayBoard();
            board.changePlayer();
        }
        //Display game results
        if (board.xWins()) {
            board.displayBoard();
            System.out.println(">>>>>>>>>Game Over!<<<<<<<<<\n"+playerX.getName()+" wins!\n");
        } else if (board.oWins()) {
            board.displayBoard();
            System.out.println(">>>>>>>>>Game Over!!<<<<<<<<<\n"+playerO.getName()+" wins!\n");
        } else {
            board.displayBoard();
            System.out.println(">>>>>>>>>Game Over!<<<<<<<<< Draw!\n");
        }
    }

    public static boolean validName(String name) {
        Pattern p = Pattern.compile("([0-9<>%\\$.])");
        Matcher m = p.matcher(name);

        if (m.find()) {
            System.out.println("INVALID NAME. MUST NOT CONTAIN NUMBERS OR SPECIAL CHARS");
            return false;
        }
        return true;
    }
}
