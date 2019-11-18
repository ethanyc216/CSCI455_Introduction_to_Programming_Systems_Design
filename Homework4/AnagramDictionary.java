// Name: Yifan Chen
// USC NetID: ychen865
// CS 455 PA4
// Fall 2019

import java.io.*;
import java.util.*;


/**
    A dictionary of all anagram sets. 
    Note: the processing is case-sensitive; so if the dictionary has all lower
    case words, you will likely want any string you test to have all lower case
    letters too, and likewise if the dictionary words are all upper case.
**/

public class AnagramDictionary {
   
    // This anagramDict maps each word's standard string to its all anagrams.
    Map<String, ArrayList<String>> anagramDict;

    /**
        Create an anagram dictionary from the list of words given in the file
        indicated by fileName.  
        PRE: The strings in the file are unique.
        @param fileName  the name of the file to read from
        @throws FileNotFoundException  if the file is not found
    **/
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        // Read each word from dictionary and store it in the anagram dictionary
        anagramDict = new HashMap<String, ArrayList<String>>();

        File file = new File(fileName);
        Scanner in = new Scanner(file);
        while (in.hasNext()) {

            String word = in.next();
            // Get the sorted version of the word
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String anagramWord = String.valueOf(charArr);

            // Build the anagramDict
            if (anagramDict.containsKey(anagramWord)) {
                anagramDict.get(anagramWord).add(word);
            }
            else {
                ArrayList<String> anagramList = new ArrayList<String>();
                anagramList.add(word);
                anagramDict.put(anagramWord, anagramList);
            }
        }

    }
   

   /**
        Get all anagrams of the given string. This method is case-sensitive.
        E.g. "CARE" and "race" would not be recognized as anagrams.
        @param s string to process
        @return a list of the anagrams of s
    **/
   public ArrayList<String> getAnagramsOf(String s) {

        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String anagramWord = String.valueOf(charArr);
        return anagramDict.get(anagramWord);
        
   }

   
}
