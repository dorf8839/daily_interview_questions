package com.company;

public class Main {

    //Traverse through rows and find first character of target string
    //If found, add to StringBuilder and continue traversal through row, adding onto StringBuilder
    //At end of for loops, if StringBuilder matches target string, return true
    //else, traverse through columns doing the same thing
    public static void main(String[] args) {
	    char[][] input = {  {'F','A','C','I'},
                            {'O','B','Q','P'},
                            {'A','N','O','B'},
                            {'M','A','S','S'}};
//	    String target = "FOAM";
//	    String target = "MASS";
	    String target = "IQBS";
        System.out.println(findWord(input, target));
    }

    public static boolean findWord(char[][] input, String target){
        String result = "";
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                if(input[i][j] == target.charAt(0)){
                    int count = 0;
                    for(int k = i; k < input.length; k++){
                        if(input[k][j] == target.charAt(count)){
                            result = result + target.charAt(count);
                            count++;
                        }
                    }
                    if(target.equals(result)){
                        return true;
                    }
                    count = 0;
                    result = "";
                    for(int k = j; k < input[i].length; k++){
                        if(input[i][k] == target.charAt(count)){
                            result = result + target.charAt(count);
                            count++;
                        }
                    }
                    if(target.equals(result)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
