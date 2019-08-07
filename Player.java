package tictactoe;

//Overview: a super class for how a basic Player functions.
public class Player {
    
    protected String full;
    
    public Player(String first){
        this.full = first;
    }

    public String getName(){
        return full;
    }
    
    //Requires: None
    //Modifies: None
    //Effects: Prompts user to mark spot on board
    public void promptInput() {

        //Checks who's turn it is
        if (TicTacToeBoard.isPlayerX()) {
            System.out.print("Player X enter an open spot to mark: ");
        } else {
            System.out.print("Player O enter an open spot to mark: ");
        }
    }
    
    //Requires: None
    //Modifies: None
    //Effects: Default value for makeMove
    public int makeMove() {

        return -1;
    }

    //Requires: 
    //Modifies: 
    //Effects: Default value for readInput
    public int readInput() {

        return -1;
    }
    
    //Effects: returns player name
    public String toString(){
        return getName();
    }
}
