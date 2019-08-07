package tictactoe;

//Overview: a child of Player, parent of EasyBotPlayer and RandomBotPlayer for basic functioanality of a computer bot playing the game
public class BotPlayer extends Player {

    public BotPlayer(String first) {
        super(first);
    }

    //Requires: None
    //Modifies: None
    //Effects: Displays message to user
    public void promptInput() {
        if (TicTacToeBoard.isPlayerX()) {
            System.out.print("Player X enter an open spot to mark: ");
        } else {
            System.out.print("Player O enter an open spot to mark: ");
        }
    }

    //Requires: None
    //Modifies: None
    //Effects: Returns a default value
    public int readInput() {
        return -1;
    }
    
    
    //Effects: returns name
    public String toString(){
        return full;
    }
}
