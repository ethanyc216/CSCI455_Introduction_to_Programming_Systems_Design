// Name: Yifan 
// USC NetID: ychen865
// CS 455 PA1
// Fall 2019

/**
 * class CoinTossSimulatorTester
 * 
 * A program to test  CoinTossSimulator class independently from its use in the
 * CoinSimViewer program.
 * Default inputs.
 * 
 **/

import java.util.*;

public class CoinTossSimulatorTester {

    public static void main(String[] args){
        // constructor
        CoinTossSimulator coinToss = new CoinTossSimulator();
        boolean correctness;

        // after constructor
        System.out.println("After constructor:");
        System.out.println("Number of trials [exp:0]: " + coinToss.getNumTrials());
        System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());

        // correstness
        correctness = coinToss.getNumTrials() == (coinToss.getTwoHeads() + coinToss.getTwoTails() + coinToss.getHeadTails());
        System.out.println("Tosses add up correctly? " + correctness);
        System.out.println();

        List<Integer> trials = Arrays.asList(1,10,100);
        int totalTrial = 0;
        for(int i=0; i<trials.size(); i++) {
            int trial = trials.get(i);
            totalTrial += trial;
            coinToss.run(trial);
            // after run(?):
            System.out.println("After run(" + trial + "):");
            System.out.println("Number of trials [exp:" + totalTrial + "]: " + coinToss.getNumTrials());
            System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
            System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
            System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());

            // correstness
            correctness = coinToss.getNumTrials() == (coinToss.getTwoHeads() + coinToss.getTwoTails() + coinToss.getHeadTails());
            System.out.println("Tosses add up correctly? " + correctness);
            System.out.println();
        }

        // reset
        coinToss.reset();

        // after reset
        System.out.println("After reset:");
        System.out.println("Number of trials [exp:0]: " + coinToss.getNumTrials());
        System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());

        // correstness
        correctness = coinToss.getNumTrials() == (coinToss.getTwoHeads() + coinToss.getTwoTails() + coinToss.getHeadTails());
        System.out.println("Tosses add up correctly? " + correctness);
        System.out.println();

        // run(1000)
        coinToss.run(1000);

        // after run(1000)
        System.out.println("After run(1000):");
        System.out.println("Number of trials [exp:1000]: " + coinToss.getNumTrials());
        System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());

        // correstness
        correctness = coinToss.getNumTrials() == (coinToss.getTwoHeads() + coinToss.getTwoTails() + coinToss.getHeadTails());
        System.out.println("Tosses add up correctly? " + correctness);
        System.out.println();
    }

}