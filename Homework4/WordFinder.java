// Name: Yifan Chen
// USC NetID: ychen865
// CS 455 PA4
// Fall 2019

import java.io.FileNotFoundException;
import java.util.*;

/**
    This class contains the main method that's responsible for processing the command- line argument, and handling any error processing.
    User could specify the path of dictionary. Default dictionary is set to "sowpods.txt".
    Run the program:
        java WordFinder [dictionaryFile]
**/

public class WordFinder {

    private static final String DEFAULT_DICTIONARY = "sowpods.txt";
    private static final String END_SYMBOL = ".";

   
    /**
        Main method, app entrance.
        Processes user's input and return the outputs.
        @param args the dictionary path, can be omitted.
    **/
    public static void main(String[] args) {

        // processing dictionary
        AnagramDictionary anagramDictionary = null;
        try {
            anagramDictionary = new AnagramDictionary(args.length == 0 ? DEFAULT_DICTIONARY : args[0]);
        }
        catch (FileNotFoundException e) {
            System.out.println("The dictionary " + (args.length == 0 ? DEFAULT_DICTIONARY : args[0]) + " does not exist!");
            System.exit(0);
        }

        // The initial program output
        System.out.println("Type " + END_SYMBOL + " to quit.");

        // A loop on the console, printing the prompt "Rack? ", reading and processing each rack, until you tell it to exit
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Rack? ");
            String letters = in.nextLine();

            // Detect if ends
            if (END_SYMBOL.equals(letters)) {
                break;
            }

            // Get all subsets
            Rack rack = new Rack();
            ArrayList<String> subsets = rack.getAllSubsets(letters);

            // Get results, scores and string
            ScoreTable scoreTable = new ScoreTable();
            HashMap<Integer, ArrayList<String>> results = new HashMap<Integer, ArrayList<String>>();
            int resultNum = 0;
            for (String s : subsets) {
                if (anagramDictionary.getAnagramsOf(s) != null) {
                    resultNum += anagramDictionary.getAnagramsOf(s).size();
                    int score = scoreTable.getScore(s);
                    if (results.containsKey(score)) {
                        ArrayList<String> scoreArrayList = new ArrayList<String>();
                        scoreArrayList.addAll(results.get(score));
                        scoreArrayList.addAll(anagramDictionary.getAnagramsOf(s));
                        results.put(score, scoreArrayList);
                    }
                    else {
                        results.put(score, anagramDictionary.getAnagramsOf(s));
                    }
                }
            }

            // Print results
            printResults(letters, results, resultNum);
        }

    }


    /**
        Print out the results.
        @param results the results that will be print out. It uses score as a key and use ArrayList of the result string as value.
        The result will be print in order of the score.
    **/
    private static void printResults(String letters, Map<Integer, ArrayList<String>> results, int resultNum) {

        System.out.println("We can make " + resultNum + " words from \"" + letters + "\"");
        if (resultNum == 0) {
            return;
        }
        System.out.println("All of the words with their scores (sorted by score):");

        Integer[] scores = results.keySet().toArray(new Integer[results.size()]);
        Arrays.sort(scores, Collections.reverseOrder());

        // Print results in descending order
        for (Integer score : scores) {
            ArrayList<String> result = results.get(score);
            Collections.sort(result);  
            for (String s : result) {
                System.out.println(score + ": " + s);
            }
        }

    }


}
