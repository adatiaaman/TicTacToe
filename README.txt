Aman Pankaj Adatia
2020CSB1154
Lab Assignment 2 - Java Programming

Compile and Run TicTacToe.java file
Commands:
javac TicTacToe.java
java TicTacToe

To start a new game press 'y', and to stop playing press 'n'

To play the two player mode, press 1 (Player 1-X, Player 2-O)
To play against the computer, press 2 (Computer always being O)

To place an X/O on the grid, enter the coordinates (space seperated)
| (1,1) | (1,2) | (1,3) |
| (2,1) | (2,2) | (2,3) |
| (3,1) | (3,2) | (3,3) |
Assuming player will only play in an empty space
Program will throw a warning if player tries to play in a filled space

Computer Move priority:
Computer will try to win if possible (Two O already alligned)
If not possible then Computer will try to block player from winning if possible (Two X already alligned)
Otherwise, computer will play randomly in any empty space
Note: Computer is not completely optimal, but it will try to win or block player from winning whenever possible

If there is no winner till all the spaces are filled on the grid, 
then the game is tied
