package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    char[][] input = {  {'c','b','a'},
                            {'d','a','f'},
                            {'g','h','i'}};
//        char[][] input = {{'a','b','c','d','e','f'}};
//        char[][] input = {  {'z','y','x'},
//                            {'w','v','u'},
//                            {'t','s','r'}};
        System.out.println("Number of columns to remove: " + columnRemoval(input));
    }

    private static int columnRemoval(char[][] input){
        int count = 0;
        if(input.length < 2){
            return 0;
        }
        for(int i = 0; i < input.length; i++) {
            for (int j = 1; j < input[i].length; j++) {
                if (input[j][i] - 'a' < input[j-1][i] - 'a') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
