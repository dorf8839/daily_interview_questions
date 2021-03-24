package com.corydorfner;

public class Main {

    public static void main(String[] args) {
        String[] input = {"ptolemaic", "retrograde", "supplant", "undulate", "winner", "xenoepist", "apple", "asymptote", "babka"};
        int n = input.length;
        System.out.println(countRotations(input, 0, n-1));
    }

    public static int countRotations(String[] input, int low, int high){
        if(high < low){
            return 0;
        }

        if(high == low){
            return low;
        }

        int mid = low + (high - low)/2;

        if(mid < high && input[mid+1].charAt(0) < input[mid].charAt(0)){
            return mid + 1;
        }

        if(mid > low && input[mid].charAt(0) < input[mid-1].charAt(0)){
            return mid;
        }

        if(input[high].charAt(0) > input[mid].charAt(0)){
            return countRotations(input, low, mid-1);
        }

        return countRotations(input, mid+1, high);
    }
}
