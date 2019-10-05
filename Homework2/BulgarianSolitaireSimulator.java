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

        Scanner in = new Scanner(System.in);
        SolitaireBoard solitaireBoard = createSolitaireBoard(userConfig, in);
        playSolitaireBoard(solitaireBoard, singleStep, in);
      
    }


    /**
     * Create a Solitaire Board according to the userConfig.
     * 
     * @param userConfig if user wants their own inputs or not. 
     *     true:  create your own inputs
     *     false: use random inputs.
     *
     * @param in: the Scanner object to read from users' inputs (System.in).
     *
     * @return a SolitaireBoard object that is gonna be play.
     *
    **/
    private static SolitaireBoard createSolitaireBoard(Boolean userConfig, Scanner in) {

        if (userConfig) {
            gameInstructions();
            List<Integer> piles = new ArrayList<Integer>();
            int numCard;
            int sum;

            while (true) {
                System.out.println("Please enter a space-separated list of positive integers followed by newline:");

                //String line = in.nextLine();
                Scanner lineScanner = new Scanner(in.nextLine());

                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextInt()) {
                        numCard = lineScanner.nextInt();
                        // inputs contain non-positive value
                        if (numCard <= 0) {
                            piles.clear();
                            break;
                        }
                        piles.add(numCard);
                    } else {
                        // inputs contain non-integer
                        piles.clear();
                        break;
                    }
                }

                sum = 0;
                for (int i = 0; i < piles.size(); i ++) {
                    sum += piles.get(i);
                }

                // inputs sum up not equal to SolitaireBoard.CARD_TOTAL
                if (sum == SolitaireBoard.CARD_TOTAL) {
                    break;
                }
                piles.clear();
                System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
            }

            return new SolitaireBoard((ArrayList<Integer> )piles);
        } else {
            return new SolitaireBoard();
        }

    }


    /**
     * Play the Bulgarian Solitaire game, and print the result according to the 
     * 
     * @param solitaireBoard: the solitaire board that is gonna be played by the program.
     * @param in: the Scanner object to read from users' inputs (System.in).
     *
    **/
    private static void playSolitaireBoard(SolitaireBoard solitaireBoard, Boolean singleStep, Scanner in) {

        int index = 0;
        System.out.println("Initial configuration: " + solitaireBoard.configString());
        while (!solitaireBoard.isDone()) {
            solitaireBoard.playRound();
            index ++;
            System.out.println("[" + index + "] Current configuration: " + solitaireBoard.configString());
            if (singleStep) {
                System.out.print("<Type return to continue>");
                in.nextLine();
            }
        }

        System.out.println("Done!");

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
