package tictactoe;

//Overview: child class of BotPlayer, represents a computer bot that marks the first available space in the board after input from another player
public class EasyBotPlayer extends BotPlayer {

    public EasyBotPlayer(String first) {
        super(first);
    }

    //Requires: None
    //Modifies: None
    //Effects: The space played has been assigned to the board 
    public int makeMove() {

        //return the first unused available spot (indexed according to the board)
        for (int i = 1; i <= 9; i++) {
            if (TicTacToeBoard.isValidSpace(i)) {
                return i;
            }
        }
        return -1;
    }
    
    //Effects: returns name
    public String toString(){
        return full;
    }
}
