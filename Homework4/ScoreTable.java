// Name: Yifan Chen
// USC NetID: ychen865
// CS 455 PA4
// Fall 2019

import java.util.*;

/**
    A ScoreTable for Scrabble Game
    In scrabble not every letter has the same value. Letters that occur more 
    often in the English language are worth less (e.g., 'e' and 's' are each 
    worth 1 point), and letters that occur less often are worth more (e.g., 
    'q' and 'z' are worth 10 points each). 
    (1 point)   -A, E, I, O, U, L, N, S, T, R 
    (2 points)  -D, G
    (3 points)  -B, C, M, P
    (4 points)  -F, H, V, W, Y
    (5 points)  -K
    (8 points)  -J, X 
    (10 points) -Q, Z
**/

public class ScoreTable {

    private static final int[] SCORE_TABLE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

   
    /**
        Gets the score of one word.
        @param word whose score we need to get
        @return the score of the word
        Score equals to the sum of the point of each letter in the word
    **/
    public int getScore(String word) {
        
        int totalScore = 0;
        // convert letters into lower case and find the corresponding score
        word = word.toLowerCase();
        for (int i = 0 ; i < word.length() ; i++) {
            totalScore += SCORE_TABLE[word.charAt(i) - 'a'];
        }
        
        return totalScore;
        
    }

    
}
