// Name: Yifan Chen
// USC NetID: ychen865
// CSCI455 PA2
// Fall 2019

import java.util.*;

/**
 * Class BulgarianSolitaireSimulator
 * 
 * Simulates Bulgarian Solitaire according to the configurations.
 * By default, it uses a random input, or you can use -u flag to type your own inputs. 
 * By default, it plays the game without stopping, or you can use -s to stop at each round.
 *
**/

public class BulgarianSolitaireSimulator {

    /**
     * Main method, start the game.
     * 
     * @param args user input flags, options: 
     *     -u: for creating your own inputs
     *     -s: for stopping at each round, continue after hitting enter.
     *
    **/
    public static void main(String[] args) {
     
        boolean singleStep = false;
        boolean userConfig = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-u")) {
                userConfig = true;
            } else if (args[i].equals("-s")) {
                singleStep = true;
            }
        }

        SolitaireBoard solitaireBoard = createSolitaireBoard(userConfig);
        playSolitaireBoard(solitaireBoard, singleStep);
      
    }


    /**
     * Create a Solitaire Board according to the userConfig.
     * 
     * @param userConfig if user wants their own inputs or not. 
     *     true:  create your own inputs
     *     false: use random inputs.
     *
    **/
    private static SolitaireBoard createSolitaireBoard(Boolean userConfig) {

        if (userConfig) {
            gameInstructions();
            Scanner in = new Scanner(System.in);
            int[] piles;
            while (true) {
                System.out.println("Please enter a space-separated list of positive integers followed by newline:");
                int[] tmpPiles = int[45];
                
                while (in.hasNext()) {
                    
                }

            }
        }

    }


    /**
     *
     * Show how to play this game.
     *
    **/
    private static void gameInstructions() {

        System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
        System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");

    }

  
}
