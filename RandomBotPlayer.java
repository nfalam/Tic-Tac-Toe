package tictactoe;

//Overview: child class of BotPlayer, plays the first available spot randomly
import java.util.Random;

public class RandomBotPlayer extends BotPlayer {

    public RandomBotPlayer(String first) {
        super(first);
    }

    //Requires: None
    //Modifies: None
    //Effects: Marks a spot on the board randomly (Random between unused spots from 1 to 9)
    public int makeMove() {

        Random generator = new Random();
        int randomInt;

        //random number generation
        randomInt = generator.nextInt(9) + 1;

        while (!(TicTacToeBoard.isValidSpace(randomInt) && randomInt <= 9 && randomInt >= 1)) {
            randomInt = generator.nextInt(9) + 1;
        }

        return randomInt;
    }

    //Effects: returns name    
    public String toString(){
        return full;
    }
}
