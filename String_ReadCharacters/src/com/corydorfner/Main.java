package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    readN("Hello World", 3);
    }

    public static String read7(){
        //Provided function
        return "test 7 ";
    }

    public static String readN(String input, int n){
        String result = "";
        String text = null;

        while (result.length() < n && (text == null || text.length() >= 5)){
            text = read7();
            result += text;
        }

        return result;
    }
}
