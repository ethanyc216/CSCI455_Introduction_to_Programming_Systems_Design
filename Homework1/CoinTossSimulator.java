// Name: Yifan 
// USC NetID: ychen865
// CS 455 PA1
// Fall 2019

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 **/

import java.util.*;

public class CoinTossSimulator {

    private Random generator;
    private int twoHeads;
    private int twoTails;
    private int headTails;
    private int numTrials;


    /**
        Creates a coin toss simulator with no trials done yet.
    **/
    public CoinTossSimulator() {
        twoHeads = 0;
        twoTails = 0;
        headTails = 0;
        numTrials = 0;
        generator = new Random();
    }


    /**
        Runs the simulation for numTrials more trials. Multiple calls to this method
        without a reset() between them *add* these trials to the current simulation.
      
        @param numTrials  number of trials to for simulation; must be >= 1
    **/
    public void run(int numTrials) {
        // get the new num of trails and add it up 
        this .numTrials += numTrials;

        // the loop for tossing coins 
        for (int i = 1; i <= numTrials; i++) {
            // 0 is tail and 1 is head
            int tossResult = generator.nextInt(2) + generator.nextInt(2);

            if (tossResult == 0) {
                twoTails++;
            } else if (tossResult == 1) {
                headTails++;
            } else {
                twoHeads++;
            }
        }
    }


    /**
        Get number of trials performed since last reset.
    **/
    public int getNumTrials() {
        return numTrials; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
        Get number of trials that came up two heads since last reset.
    **/
    public int getTwoHeads() {
        return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
        Get number of trials that came up two tails since last reset.
    **/  
    public int getTwoTails() {
        return twoTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
        Get number of trials that came up one head and one tail since last reset.
    **/
    public int getHeadTails() {
        return headTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
        Resets the simulation, so that subsequent runs start from 0 trials done.
    **/
    public void reset() {
        twoHeads = 0;
        twoTails = 0;
        headTails = 0;
        numTrials = 0;
    }

}
