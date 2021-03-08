package com.company;

public class Main {

    //Each long URL will have an integer id in the database, which will be converted
    //to a character string that is at most 6 characters long
    //A short URL character can be any of the following
        //A lowercase alphabet ['a' to 'z'], total of 26 characters
        //An uppercase alphabet ['A' to 'Z'], total of 26 characters
        //A digit ['0' to '9'], total of 10 characters
        //There are 26 + 26 + 10 = 62 possible characters
    //Task will be to convert a decimal number to base 62 number

    public static void main(String[] args) {
	    int n = 12345;
	    String shortURL = shorten(n);
        System.out.println("Generated short url is " + shortURL);
        System.out.println("ID from url is " + restore(shortURL));
        n = 123456789;
        shortURL = shorten(n);
        System.out.println("Generated short url is " + shortURL);
        System.out.println("ID from url is " + restore(shortURL));
        n = 12345;
        shortURL = shorten(n);
        System.out.println("Generated short url is " + shortURL);
        System.out.println("ID from url is " + restore(shortURL));
    }

    //Function to generate a short URL from an integer ID
    static String shorten(int n){
        //Map to store 62 possible characters
        char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shortURL = new StringBuffer();

        //Convert given integer id to a base 62 number
        while(n > 0){
            //Use above map to store actual character in short URL
            shortURL.append(map[n % 62]);
            n = n / 62;
        }

        //Reverse shortURL to complete base conversiopn
        return shortURL.reverse().toString();
    }

    //Function to get integer ID back from a short URL
    static int restore(String shortURL){
        int id = 0; //initialize result

        //A simple base conversion logic
        for(int i = 0; i < shortURL.length(); i++){
            if('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z'){
                id = id * 62 + shortURL.charAt(i) - 'a';
            }
            if('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z'){
                id = id * 62 + shortURL.charAt(i) - 'A' + 26;
            }
            if('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9'){
                id = id * 62 + shortURL.charAt(i) - '0' + 52;
            }
        }
        return id;
    }
}
