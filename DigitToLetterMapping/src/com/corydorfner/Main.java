package com.corydorfner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] number = {2,3};
        int n = number.length;

        letterCombos(number, n);
    }

    //Function that creates the mapping and calls letterCombosUtil
    public static void letterCombos(int[] number, int n){
        //Table[i] stores all characters that corresponds to ith digit in phone
        String[] table = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> list = letterCombosUtil(number, n, table);

        //Print the contents of the list
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    //Function to return a vector that contains all the generated letter combinations
    public static ArrayList<String> letterCombosUtil(int[] number, int n, String[] table){
        //To store the generated letter combinations
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty()){
            String s = q.remove();

            //If complete, word is generated. Push it in the list
            if(s.length() == n){
                list.add(s);
            }else{
                String val = table[number[s.length()]];
                for(int i = 0; i < val.length(); i++){
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }

}
