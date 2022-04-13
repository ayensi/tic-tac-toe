import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.tools.OptionChecker;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] underScoreArray = {{'_','_','_'},
            {'_','_','_'},
            {'_','_','_'}};
            

            //Task 2: Call the function printBoard();
            printBoard(underScoreArray);
             
              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */
            char turn = 'X';
            int[] answer=new int[2];
            int winner = 0;
            while(winner != 3 && winner != -3){
              if(turn=='X'){
                System.out.println("\n X's turn");
                 answer = askUser(underScoreArray);
                 underScoreArray[answer[0]][answer[1]] = 'X';
                 turn = 'O';
              }
              else{
                System.out.println("\n O's turn");
                answer = askUser(underScoreArray);
                underScoreArray[answer[0]][answer[1]] = 'O';
                turn = 'X';
              }
              printBoard(underScoreArray);
              winner = checkWin(underScoreArray);
              if(winner==3){
                System.out.println("\n X wins!");
              }
              else if(winner ==-3){
                System.out.println("\n O wins!");
              }
            }
            scan.close();
        }


    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */        
    public static void printBoard(char[][] board){
        System.out.println();

        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            System.out.print(board[i][j]+"\t");
          }
          System.out.println("\n");
        }
        System.out.println();
    }
   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

     public static int[] askUser(char[][] board){
       int row,column;
       row = 0;
       column = 0;
      int counter=0;
       for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
          if (board[i][j]=='_') {
            counter++;
          }
         }
       }
       if(counter==0){
         System.out.println("Game over");
         System.exit(0);
       }

      while (true){
        System.out.println("Pick a row and column number: ");
        System.out.println("Row: ");
        row = Integer.parseInt(scan.next());
        scan.nextLine();
        System.out.println("Column: ");
        column = Integer.parseInt(scan.next());
        scan.nextLine();

        if (board[row][column]=='_') {
          break;
        }
      }

      int[] places = {row,column};
      return places; 
     }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
     public static int checkWin(char[][] board){
       int xRowCounter,xColumnCounter,xRightDia,xLeftDia,oRowCounter,oColumnCounter,oRightDia,oLeftDia;
       xRowCounter=0;
       xColumnCounter=0;
       xRightDia=0;
       xLeftDia=0;
       oRowCounter=0;
       oColumnCounter=0;
       oRightDia=0;
       oLeftDia=0;
       for (int i = 0; i < board.length; i++) {
        
         for (int j = 0; j < board[i].length; j++) {
           if(board[i][j]=='X'){
             if((i==0&&j==0) || (i==1&&j==1) || (i==2&&j==2)){
                xRightDia++;
                if(xRightDia==3){
                  return 3;
                }
             }
             if((i==0&&j==2) || (i==1&&j==1) || (i==2&&j==0)){
               xLeftDia++;
               if(xLeftDia==3){
                 return 3;
               }
             }
             xRowCounter++;
             oRowCounter = 0;
           }
           if(board[i][j]=='O'){
            if((i==0&&j==0) || (i==1&&j==1) || (i==2&&j==2)){
               oRightDia++;
               if(oRightDia==3){
                 return -3;
               }
            }
           if((i==2&&j==0) || (i==1&&j==1) || (i==0&&j==2)){
              oLeftDia++;
              if(oLeftDia==3){
                return -3;
              }
            }
            oRowCounter++;
            xRowCounter = 0;
          }
          if(board[j][i]=='X'){
            xColumnCounter++;
            oColumnCounter=0;
          }
          if(board[j][i]=='O'){
            oColumnCounter++;
            xColumnCounter=0;
          }
         }
         if(xRowCounter == 3){
           return 3;
         }
         else if(oRowCounter==3){
           return -3;
         }
         else if(xColumnCounter==3){
          return 3;
         }
         else if(oColumnCounter==3){
           return -3;
         }
         xRowCounter=0;
         oRowCounter=0;
         xColumnCounter=0;
         xRowCounter=0;
       }
       return 0;
     }

}
