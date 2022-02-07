// Aman Pankaj Adatia 
// 2020CSB1154
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // for taking input
        System.out.println("Welcome to Tic Tac Toe.");

        while(true){
            System.out.println("New Game [y/n]: ");
            char play = sc.next().charAt(0);
            // | (1,1) | (1,2) | (1,3) |
            // | (2,1) | (2,2) | (2,3) |
            // | (3,1) | (3,2) | (3,3) |

            if(play=='y' || play=='Y'){
                System.out.println("Enter 1 to play Two Player mode or Enter 2 to play the Computer mode: ");
                int gameMode = sc.nextInt();

                if(gameMode==1){ // Two Player mode
                    System.out.println("Player 1 is X, Player 2 is O");
                    System.out.println("3 x 3 board");
                    // object of Board class
                    Board mat = new Board();
                    mat.showBoard(); // display initial empty grid
                    int counter=0; // keeping track to total moves
                    while(true){
                        // checking winner
                        if(mat.winCheck('X') == true){
                            System.out.println("Player 1 wins!");
                            break;
                        }
                        if(mat.winCheck('O') == true){
                            System.out.println("Player 2 wins!");
                            break;
                        }
                        // tie case
                        if(mat.winCheck('O')==false && mat.winCheck('X')==false && mat.checkFull()==true){
                            System.out.println("Game Tie!");
                            break;
                        }
                        // continue play
                        if(counter%2==0){ // player 1 turn
                            System.out.println("Player 1 (X): Enter X Y coordinates: ");
                            int A = sc.nextInt(), B = sc.nextInt(); 
                            if(mat.insert('X', A, B)==false){
                                System.out.println("Please play in an empty space.");
                                counter++;
                            }
                            mat.insert('X', A, B);
                        }
                        else{ // player 2 turn
                            System.out.println("Player 2 (O): Enter X Y coordinates: ");
                            int A = sc.nextInt(), B = sc.nextInt(); 
                            if(mat.insert('O', A, B)==false){
                                System.out.println("Please play in an empty space.");
                                counter++;
                            }
                            mat.insert('O', A, B);
                        }
                        // printing the current grid
                        mat.showBoard();
                        counter++;
                    }
                }
                else if(gameMode==2){ // Computer mode
                    System.out.println("Player is X, Computer is O");
                    System.out.println("3 x 3 board");
                    Board mat = new Board();
                    mat.showBoard();
                    int counter=0;
                    while(true){
                        // checking winner
                        if(mat.winCheck('X') == true){
                            System.out.println("Player 1 wins!");
                            break;
                        }
                        if(mat.winCheck('O') == true){
                            System.out.println("Computer wins!");
                            break;
                        }
                        // tie case
                        if(mat.winCheck('O')==false && mat.winCheck('X')==false && mat.checkFull()==true){
                            System.out.println("Game Tie!");
                            break;
                        }
                        // continue play
                        if(counter%2==0){ // player 1 turn
                            System.out.println("Player 1 (X): Enter X Y coordinates: ");
                            int A = sc.nextInt(), B = sc.nextInt(); 
                            if(mat.insert('X', A, B)==false){
                                System.out.println("Please play in an empty space.");
                                counter++;
                            }
                            mat.insert('X', A, B);
                        }
                        else{ // player 2 turn
                            System.out.println("Computer (O) played. ");
                            mat.insertComputer('O');
                        }
                        // printing the current grid
                        mat.showBoard();
                        counter++;
                    }
                }
                else{
                    System.out.println("Enter a valid number...");
                }
            }
            else{
                break;
            }
        }
        System.out.println("Thanks for playing!");
        sc.close();
    }
}

class Board {
    char[][] board = new char[3][3];
    
    // initialise
    Board() { // constructor
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.board[i][j] = '_';
            }
        }
    }

    // adding X or O to the grid (player)
    // assuming player plays in an empty space
    boolean insert(char ttt, int a, int b) {
        if(this.board[a-1][b-1]!='_') {
            // System.out.println("Please play in an empty space.");
            return false;
        }
        else{
            this.board[a-1][b-1] = ttt;
            return true;
        }
    }

    // adding O to the grid for computer
    void insertComputer(char ttt){
        int play = 0; // variable to conntrol that the computer plays only once in a single turn
        // computers priority is to win first, then to block player, if none of them are possible then play randomly

        // checking if computer can win and playing accordingly
        for(int i=0; i<3; i++){ // checking rows
            if(this.board[i][0]=='O' && this.board[i][1]=='O' && this.board[i][2]=='_'){
                this.board[i][2]='O';
                play=1;
                break;
            }
            if(this.board[i][0]=='O' && this.board[i][1]=='_' && this.board[i][2]=='O'){
                this.board[i][1]='O';
                play=1;
                break;
            }
            if(this.board[i][0]=='_' && this.board[i][1]=='O' && this.board[i][2]=='O'){
                this.board[i][0]='O';
                play=1;
                break;
            }
        }
        if(play==0){
            for(int j=0; j<3; j++){ // checking columns
                if(this.board[0][j]=='O' && this.board[1][j]=='O' && this.board[2][j]=='_'){
                    this.board[2][j]='O';
                    play=1;
                    break;
                }
                if(this.board[0][j]=='O' && this.board[1][j]=='_' && this.board[2][j]=='O'){
                    this.board[1][j]='O';
                    play=1;
                    break;
                }
                if(this.board[0][j]=='_' && this.board[1][j]=='O' && this.board[2][j]=='O'){
                    this.board[0][j]='O';
                    play=1;
                    break;
                }
            }
        }
        if(play==0){ // checking diagonally
            if(this.board[0][0]=='O' && this.board[1][1]=='O' && this.board[2][2]=='_'){
                this.board[2][2]='O';
                play=1;
            }
            else if(this.board[0][0]=='O' && this.board[1][1]=='_' && this.board[2][2]=='O'){
                this.board[1][1]='O';
                play=1;
            }
            else if(this.board[0][0]=='_' && this.board[1][1]=='O' && this.board[2][2]=='O'){
                this.board[0][0]='O';
                play=1;
            }
            if(play==0){
                if(this.board[0][2]=='O' && this.board[1][1]=='O' && this.board[2][0]=='_'){
                    this.board[2][0]='O';
                    play=1;
                }
                else if(this.board[0][2]=='O' && this.board[1][1]=='_' && this.board[2][0]=='O'){
                    this.board[1][1]='O';
                    play=1;
                }
                else if(this.board[0][2]=='_' && this.board[1][1]=='O' && this.board[2][0]=='O'){
                    this.board[0][2]='O';
                    play=1;
                }
            }
        }
        // checking if computer can block player from winning in the next move
        if(play==0){
            for(int i=0; i<3; i++){ // checking row
                if(this.board[i][0]=='X' && this.board[i][1]=='X' && this.board[i][2]=='_'){
                    this.board[i][2]='O';
                    play=1;
                    break;
                }
                if(this.board[i][0]=='X' && this.board[i][1]=='_' && this.board[i][2]=='X'){
                    this.board[i][1]='O';
                    play=1;
                    break;
                }
                if(this.board[i][0]=='_' && this.board[i][1]=='X' && this.board[i][2]=='X'){
                    this.board[i][0]='O';
                    play=1;
                    break;
                }
            }
            if(play==0){
                for(int j=0; j<3; j++){ // checking column
                    if(this.board[0][j]=='X' && this.board[1][j]=='X' && this.board[2][j]=='_'){
                        this.board[2][j]='O';
                        play=1;
                        break;
                    }
                    if(this.board[0][j]=='X' && this.board[1][j]=='_' && this.board[2][j]=='X'){
                        this.board[1][j]='O';
                        play=1;
                        break;
                    }
                    if(this.board[0][j]=='_' && this.board[1][j]=='X' && this.board[2][j]=='X'){
                        this.board[0][j]='O';
                        play=1;
                        break;
                    }
                }
            }
            if(play==0){ // checking diagonally
                if(this.board[0][0]=='X' && this.board[1][1]=='X' && this.board[2][2]=='_'){
                    this.board[2][2]='O';
                    play=1;
                }
                else if(this.board[0][0]=='X' && this.board[1][1]=='_' && this.board[2][2]=='X'){
                    this.board[1][1]='O';
                    play=1;
                }
                else if(this.board[0][0]=='_' && this.board[1][1]=='X' && this.board[2][2]=='X'){
                    this.board[0][0]='O';
                    play=1;
                }
                if(play==0){
                    if(this.board[0][2]=='X' && this.board[1][1]=='X' && this.board[2][0]=='_'){
                        this.board[2][0]='O';
                        play=1;
                    }
                    else if(this.board[0][2]=='X' && this.board[1][1]=='_' && this.board[2][0]=='X'){
                        this.board[1][1]='O';
                        play=1;
                    }
                    else if(this.board[0][2]=='_' && this.board[1][1]=='X' && this.board[2][0]=='X'){
                        this.board[0][2]='O';
                        play=1;
                    }
                }
            }
        }
        // Finding empty space randomly
        if(play==0){
            while(true){
                Random rand = new Random();
                int a = rand.nextInt(3), b = rand.nextInt(3);
                if(this.board[a][b]=='_'){
                    this.board[a][b]='O';
                    break;
                }
            }
        }
    }

    // printing the grid 
    void showBoard() {
        for(int i=0; i<3; i++){
            System.out.print(" | ");
            for(int j=0; j<3; j++){
                System.out.print(this.board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    // checking the winner
    boolean winCheck(char ttt) {
        // rows
        if(board[0][0]==ttt && board[0][1]==ttt && board[0][2]==ttt)
			return true;
        if(board[1][0]==ttt && board[1][1]==ttt && board[1][2]==ttt)
            return true;
        if(board[2][0]==ttt && board[2][1]==ttt && board[2][2]==ttt)
            return true;
            
        //columns
        if(board[0][0]==ttt && board[1][0]==ttt && board[2][0]==ttt)
            return true;
        if(board[0][1]==ttt && board[1][1]==ttt && board[2][1]==ttt)
            return true;
        if(board[0][2]==ttt && board[1][2]==ttt && board[2][2]==ttt)
            return true;
        
        //diagonals
        if(board[0][0]==ttt && board[1][1]==ttt && board[2][2]==ttt)
            return true;
        if(board[0][2]==ttt && board[1][1]==ttt && board[2][0]==ttt)
            return true;

        return false;
    }

    // checking if all places are full
    boolean checkFull(){
        int checker=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.board[i][j] != '_'){
                    checker++;
                }
            }
        }
        if(checker==9){
            return true;
        }
        else{
            return false;
        }
    }
}
