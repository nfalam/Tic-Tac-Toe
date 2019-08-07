package tictactoe;

//Overview: child class of Player that is based on input from a human
import java.util.*;

public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);
    private int inputVal;

    public HumanPlayer(String fullName) {
        super(fullName);
    }

    //Requires: None
    //Modifies: inputVal the input value entered from stdin
    //Effects: Updates board with new move
    public int makeMove() {

        try {
            inputVal = scanner.nextInt();

            // checking for valid space between 1 and 9
            if (inputVal < 1 || inputVal > 9 || !TicTacToeBoard.isValidSpace(inputVal)) {

                System.out.println("Please enter an open spot between 1 and 9.");
                promptInput();
                makeMove();
            }
        } // Exception handling: will exit when caught // Exception handling: will exit when caught
        catch (InputMismatchException e) {

            System.out.println("Integers between 1 and 9 only... Try again. Program exiting!");
            System.exit(1);
        } catch (NoSuchElementException e) {

            System.out.println("No such element! Sorry bout that... Program exiting.");
            System.exit(2);
        } catch (IllegalStateException e) {

            System.out.println("Scanner is closed. Exiting.");
            System.exit(3);
        }

        return inputVal;
    }
    
    //Effects: returns name
    public String toString(){
        return full;
    }
}
