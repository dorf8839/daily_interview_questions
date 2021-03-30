package com.corydorfner;

//info on solution: https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class Main {

    public static void main(String[] args) {
//	    int[] input = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
//	    int[] input = {2,5,3,7,11,8,10,13,6,15};
	    int[] input = {2,1};
	    int subInput = longestSubArray(input);
        System.out.println(subInput);
    }

    private static int longestSubArray(int[] input){
        int size = input.length;
        //Add boundary case, when array size is one
        int[] tailTable = new int[size];
        int len; //always points empty slot

        tailTable[0] = input[0];
        len = 1;
        for(int i = 1; i < size; i++){
            if(input[i] < tailTable[0]){
                //new smallest value
                tailTable[0] = input[i];
            }else if(input[i] > tailTable[len - 1]){
                //input[i] wants to extend largest subsequence
                tailTable[len++] = input[i];
            }else{
                //input[i] wants to be current end candidate of an existing
                //subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, input[i])] = input[i];
            }
        }
        return len;
    }

    private static int CeilIndex(int[] input, int l, int r, int key){
        while(r - l > 1){
            int m = l + (r - l) / 2;
            if(input[m] >= key){
                r = m;
            }else{
                l = m;
            }
        }
        return r;
    }
}
