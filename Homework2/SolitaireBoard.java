// Name: Yifan Chen
// USC NetID: ychen865
// CSCI455 PA2
// Fall 2019

import java.util.*;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total 
  number of cards is for the game by changing NUM_FINAL_PILES, below.  
  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.  (See comments 
  below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
    public static final int NUM_FINAL_PILES = 9;
    // number of piles in a final configuration
    // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
    public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
    // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
    // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
    // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

    // Note to students: you may not use an ArrayList -- see assgt 
    // description for details.
   
   
    /**
        Representation invariant:
            numPiles: the number of piles, in range (0, CARD_TOTAL]
            pilesArr: the partially-filled array to store the number of cards in that pile.
                      The index of pilesArr is in range [0, numPiles-1].
                      Every element in the pilesArr should be greater than 0.
                      CARD_TOTAL is the sum of all elements in pilesArr.
                      When a pile has ZERO card, it will be removed from the array.
                      A new pile will be created at the end of pilesArr each round.


    **/
   
    private int[] pilesArr = new int[CARD_TOTAL];
    private int numPiles;
  
 
    /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of 
      cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to 
      SolitaireBoard.CARD_TOTAL
    **/
    public SolitaireBoard(ArrayList<Integer> piles) {

        numPiles = piles.size();

        for (int i = 0 ; i < numPiles ; i ++) {
            pilesArr[i] = piles.get(i);
        }
        // sample assert statement (you will be adding more of these calls)
        // this statement stays at the end of the constructor.
        assert isValidSolitaireBoard();

    }
 
   
    /**
      Creates a solitaire board with a random initial configuration.
    **/
    public SolitaireBoard() {

        Random random = new Random();
        int sum = 0;
        int i;

        for (i = 0; ; i ++) {
            pilesArr[i] = random.nextInt(CARD_TOTAL - sum) + 1;
            sum += pilesArr[i];
            if (sum == CARD_TOTAL) {
                break;
            }
        }

        numPiles = i + 1;
        // make sure its a valid input
        assert isValidSolitaireBoard();

    }
  
   
    /**
      Plays one round of Bulgarian solitaire.  Updates the configuration 
      according to the rules of Bulgarian solitaire: Takes one card from each
      pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
    **/
    public void playRound() {

        int offset = 0;
        int numPilesOld = numPiles;

        for (int i = 0; i < numPilesOld; i ++) {
            if (pilesArr[i] == 1) {
                offset ++; 
                numPiles --;
            } else {
                pilesArr[i - offset] = pilesArr[i] - 1;
            }
        }

        numPiles ++;
        pilesArr[numPiles - 1] = numPilesOld;

        assert isValidSolitaireBoard();

    }
   
    /**
      Returns true iff the current board is at the end of the game.  That is, 
      there are NUM_FINAL_PILES piles that are of sizes 
      1, 2, 3, . . . , NUM_FINAL_PILES, 
      in any order.
    **/
   
    public boolean isDone() {

        assert isValidSolitaireBoard();

        boolean[] checkArr = new boolean[CARD_TOTAL + 1];

        // Loop all numbers in pilesArr, set checkArr[i] to be true if numbers present in pilesArr.
        for (int i : pilesArr) {
            checkArr[i] = true;
        }

        // Check if numbers in range [1, 9] present in pilesArr.
        for (int i = 1; i <= NUM_FINAL_PILES; i ++) {
            if (checkArr[i] == false) {
                return false;
            }
        }
        return true; 
      
    }

   
    /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
    **/
    public String configString() {

        assert isValidSolitaireBoard();
        
        // create a StringBuffer to store strings and loop all the numbers
        StringBuffer buf = new StringBuffer();
        for (int i = 0 ; i < numPiles - 1; i ++) {
            buf.append(pilesArr[i] + " ");
        }
        buf.append(pilesArr[numPiles - 1]);

        return buf.toString();

    }
   
   
    /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
    **/
    private boolean isValidSolitaireBoard() {
      
        int cardsNum = 0;
        for (int i = 0 ; i < numPiles; i ++) {
            if (pilesArr[i] < 1 || pilesArr[i] > SolitaireBoard.CARD_TOTAL) {
                return false;
            }
            cardsNum += pilesArr[i];
        }

        if (cardsNum != CARD_TOTAL) {
            return false;
        }
        return true;

    }

}
