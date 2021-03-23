package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    int n = 21032;
        System.out.println(perfectNumberGenerator(n));
    }

    public static int perfectNumberGenerator(int n){
        int sum = 0;
        int check = 10;
        String input = String.valueOf(n);
        for(int i = 0; i < input.length(); i++){
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        if(sum < 10) {
            int remainder = check - sum;
            return (n * check) + remainder;
        }else if(sum == 10){
            return n;
        }else {
            return -1;
        }
    }
}
