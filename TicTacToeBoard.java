package tictactoe;

//Overview: draws the TicTacToe board and keeps track of the marked locations, wins and valid spaces.

import java.util.Arrays;

public class TicTacToeBoard implements Board {

    private static int[][] board = new int[3][3];
    private static boolean playerX = true;
    private static boolean playerO = true;

    //Constructor that creates empty playing board
    public TicTacToeBoard() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                board[i][j] = 0;
            }
        }
    }

    //Requires: None
    //Modifies: None
    //Effects: Draws a text-based representation of the board
    public void displayBoard() {

        System.out.print("\n");
        for (int i = 0; i <= 2; i++) {
            //Draws empty board
            for (int j = 0; j <= 2; j++) {

                if (board[i][j] == 0 && j < 2) {
                    System.out.print(" |");
                } else if (board[i][j] == 0 && j == 2 && i < 2) {
                    System.out.print(" \n-----\n");
                } else if (board[i][j] == 0 && j == 2 && i == 2) {
                    System.out.println(" \n");
                } //Draws board with any X's in the relevant place
                else if (board[i][j] == 1 && j < 2) {
                    System.out.print("X|");
                } else if (board[i][j] == 1 && j == 2 && i < 2) {
                    System.out.print("X\n-----\n");
                } else if (board[i][j] == 1 && j == 2 && i == 2) {
                    System.out.println("X\n");
                }
                else if (board[i][j] == 2 && j < 2) {
                    System.out.print("O|");
                } else if (board[i][j] == 2 && j == 2 && i < 2) {
                    System.out.print("O\n-----\n");
                } else if (board[i][j] == 2 && j == 2 && i == 2) {
                    System.out.println("O\n");
                }
            }
        }
    }

    //Requres: There is a board and a player has entered in a board to mark with an integer
    //Modifies: Modifies the board depending on value of boardElement (1 through 9)
    //Effects: The board is marked with integers 1 or 2 which represents the "X" or "O" player.
    public void turn(int boardElement) {

        if (playerX) {
            switch (boardElement) {
                case 1:
                    board[0][0] = 1;
                    break;
                case 2:
                    board[0][1] = 1;
                    break;
                case 3:
                    board[0][2] = 1;
                    break;
                case 4:
                    board[1][0] = 1;
                    break;
                case 5:
                    board[1][1] = 1;
                    break;
                case 6:
                    board[1][2] = 1;
                    break;
                case 7:
                    board[2][0] = 1;
                    break;
                case 8:
                    board[2][1] = 1;
                    break;
                case 9:
                    board[2][2] = 1;
                    break;
            }
        }
        else {
            switch (boardElement) {
                case 1:
                    board[0][0] = 2;
                    break;
                case 2:
                    board[0][1] = 2;
                    break;
                case 3:
                    board[0][2] = 2;
                    break;
                case 4:
                    board[1][0] = 2;
                    break;
                case 5:
                    board[1][1] = 2;
                    break;
                case 6:
                    board[1][2] = 2;
                    break;
                case 7:
                    board[2][0] = 2;
                    break;
                case 8:
                    board[2][1] = 2;
                    break;
                case 9:
                    board[2][2] = 2;
                    break;
            }
        }
    }

    //Requires: The position of the board.
    //Modifies: None
    //Effects: The board is returned.
    public static int getSpace(int i) {

        switch (i) {
            case 1:
                return board[0][0];
            case 2:
                return board[0][1];
            case 3:
                return board[0][2];
            case 4:
                return board[1][0];
            case 5:
                return board[1][1];
            case 6:
                return board[1][2];
            case 7:
                return board[2][0];
            case 8:
                return board[2][1];
            case 9:
                return board[2][2];
        }
        return -1;
    }

    //Requires: None
    //Modifies: The states of the players
    //Effects: Swaps turn to opposite player
    public void changePlayer() {
        if (playerX) {
            playerX = false;
            playerO = true;
        } else {
            playerX = true;
            playerO = false;
        }
    }

    //Requires: None
    //Modifies: None
    //Effects: Returns whose turn it is. Player O is implicitely false.
    public static boolean isPlayerX() {
        return playerX;
    }
    
    //Requires: None
    //Modifies: None
    //Effects: Returns true if any of the following conditions are met for "X".
    public boolean xWins() {

        if (board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) {
            return true;
        } else if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1) {
            return true;
        } else if (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1) {
            return true;
        } else if (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) {
            return true;
        } else if (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1) {
            return true;
        } else if (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1) {
            return true;
        } else if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
            return true;
        } else if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
            return true;
        } else {
            return false;
        }

    }
    
    //Requires: None
    //Modifies: None
    //Post: Returns true if any of the following conditions are met for "O".
    public boolean oWins() {

        if (board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) {
            return true;
        } else if (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2) {
            return true;
        } else if (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2) {
            return true;
        } else if (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2) {
            return true;
        } else if (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2) {
            return true;
        } else if (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2) {
            return true;
        } else if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
            return true;
        } else if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    //Requires: None
    //Modifies: None
    //Effects: Returns true if game is a tie.
    public boolean draw() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
    
    //Requires: An integer input from the board
    //Modifies: None
    //Effects: Returns true or false depending on status of each element of the board.
    public static boolean isValidSpace(int input) {

        switch (input) {

            case 1:
                if (board[0][0] != 0) {
                    return false;
                }
                break;
            case 2:
                if (board[0][1] != 0) {
                    return false;
                }
                break;
            case 3:
                if (board[0][2] != 0) {
                    return false;
                }
                break;
            case 4:
                if (board[1][0] != 0) {
                    return false;
                }
                break;
            case 5:
                if (board[1][1] != 0) {
                    return false;
                }
                break;
            case 6:
                if (board[1][2] != 0) {
                    return false;
                }
                break;
            case 7:
                if (board[2][0] != 0) {
                    return false;
                }
                break;
            case 8:
                if (board[2][1] != 0) {
                    return false;
                }
                break;
            case 9:
                if (board[2][2] != 0) {
                    return false;
                }
                break;
        }
        return true;
    }
    
    //Effects: returns the board String representation
    public String toString(){
        return Arrays.toString(board);
    }
}
