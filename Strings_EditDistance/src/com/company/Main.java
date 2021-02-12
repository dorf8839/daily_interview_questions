package com.company;

import java.util.ArrayList;

public class Main {

    //Given two strings, find the edit distance between them
    //The min number of insertions, deletions, and substitutions required to change one string to another
    //Loop through first string with nested loop for second string starting at j = i
    //If chars match, break out of nested loop.  Don't increment count
    //If chars don't match but j+1 matches, delete and increment count
    //If chars don't match but i+1 matches, insert and increment count
    //If chars don't match and j+1 does not match, substitute and increment count

    public static void main(String[] args) {
	    String str1 = "kitten";
	    String str2 = "sitting";
	    editDistDP(str1, str2);
    }

    public static void editDistDP(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        // Create a DP array to memoize result
        // of previous computations
        int[][] dp = new int[2][len1 + 1];


        // Base condition when second String
        // is empty then we remove all characters
        for (int i = 0; i <= len1; i++) {
            dp[0][i] = i;
        }

        // Start filling the DP
        // This loop run for every
        // character in second String
        for (int i = 1; i <= len2; i++) {
            // This loop compares the char from
            // second String with first String
            // characters
            for (int j = 0; j <= len1; j++) {
                // if first String is empty then
                // we have to perform add character
                // operation to get second String
                if (j == 0) {
                    dp[i % 2][j] = i;
                    // if character from both String
                    // is same then we do not perform any
                    // operation . here i % 2 is for bound
                    // the row number.
                }else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                }else {
                // if character from both String is
                // not same then we take the minimum
                // from three specified operation
                    dp[i % 2][j] = 1 + Math.min(dp[(i - 1) % 2][j],
                            Math.min(dp[i % 2][j - 1],
                                    dp[(i - 1) % 2][j - 1]));
                }
            }
        }

        // after complete fill the DP array
        // if the len2 is even then we end
        // up in the 0th row else we end up
        // in the 1th row so we take len2 % 2
        // to get row
        System.out.print("The minimum edit distance between " + str1 + " and " + str2 + " is " + dp[len2 % 2][len1] +"\n");
    }
}
