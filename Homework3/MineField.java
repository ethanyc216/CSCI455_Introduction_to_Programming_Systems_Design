// Name: Yifan Chen
// USC NetID: ychen865
// CS 455 PA3
// Fall 2019


import java.util.*;
/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   // numRows: the number of rows in the field
   // numCols: the number of columns in the field
   // This defines the shape of the minefield
   // numMines: the number of mines in total in the minefield
   // mineData: the 2D boolean array to store if there is a mine in the location i, j
   private int numRows;
   private int numCols;
   private int numMines; 
   private boolean[][] mineData;
   
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {

      numRows = mineData.length;
      numCols = mineData[0].length;
      this. mineData = mineData; 

      for (int j = 0; j < numRows; j ++) {
         for (int i = 0; i < numCols; i ++) { 
            if (mineData[j][i]) { 
               numMines ++;
            }   
         }   
      }

   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {

      this. numRows = numRows;
      this. numCols = numCols;
      this. numMines = numMines;
      this. mineData = new boolean[numRows][numCols];

   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {

      resetEmpty();
      Random random = new Random();
      int rowMine = 0;
      int colMine = 0;
      int count = 0;

      while (count < numMines) {
         
         rowMine = random.nextInt(numRows);
         colMine = random.nextInt(numCols);

         if ((row == rowMine && col == colMine) || hasMine(rowMine, colMine)) {
            continue;
         }
         else {
            mineData[rowMine][colMine] = true;
            count ++;
         }
         
      }
      
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {

      for (int j = 0; j < numRows; j ++) {
         for (int i = 0; i < numCols; i ++) {
            mineData[j][i] = false;
         }
      }

   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {

      int numAdjacentMines = 0;
      for (int j = -1; j < 2; j ++) {
         for (int i = -1; i < 2; i ++) {
            if (j == 0 && i == 0) {
               continue;
            } 
            else if (inRange(row + j, col + i) && hasMine(row + j, col + i)) {
               numAdjacentMines ++;
            }
         }
      }
 
      return numAdjacentMines;

   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {

      if (row < 0 || row >= numRows) { 
         return false; 
      }
      if (col < 0 || col >= numCols) { 
         return false; 
      }
      return true;
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return numRows;
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return numCols;
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      return mineData[row][col];
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      return numMines;
   }

   
   // <put private methods here>
   
         
}

