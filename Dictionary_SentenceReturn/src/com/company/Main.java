package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Main {

    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
	    //Array of strings to be added in dictionary set
        String[] temp_dictionary = {"mobile", "samsung", "sam", "sung",
                                    "man", "mango", "icecream", "and",
                                    "go", "i", "like", "ice", "cream"};

        //loop to add all strings in dictionary set
        for(String temp : temp_dictionary){
            dictionary.add(temp);
        }

        //sample input cases
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
    }

    //Returns true if the word can be segmented into parts such
    //that each part is contained in dictionary
    public static boolean wordBreak(String word){
        int size = word.length();

        //base case
        if(size ==0){
            return true;
        }

        //else check for all words
        for(int i = 1; i <= size; i++){
            //Now we will first divide the word into two parts,
            //the prefix will have a length of i and check if it is
            //present in dictionary.  If yes, then we will check for
            //suffix of length size-i recursively.  If both prefix
            //and suffix are present, the word is found in dictionary
            if(dictionary.contains(word.substring(0, i)) &&
                    wordBreak(word.substring(i, size))){
                return true;
            }
        }

        //if all cases failed, then return false
        return false;
    }
}
