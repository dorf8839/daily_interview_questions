package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(numberOfPaths(3,3));
    }

    //Using combinatorics equation
    public static int numberOfPaths(int m, int n){
        //We have to calculate m+n-2 C n-1 here
        //which will be (m+n-2)! / (n-1)! (m-1)!
        int path = 1;
        for(int i = n; i < (m + n - 1); i++){
            path *= i;
            path /= (i - n + 1);
        }
        return path;
    }

//    //Optimized Dynamic Programming (Time Complexity of O(mn) and Space Complexity of O(m))
//    public static int numberOfPaths(int m , int n){
//        //Create the 1D array to store results of subproblems
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for(int i = 0; i < m; i++){
//            for(int j = 1; j < n; j++){
//                dp[j] += dp[j - 1];
//            }
//        }
//        return dp[n - 1];
//    }

//    //Dynamic Programming (Time and Space complexity of O(mn))
//    public static int numberOfPaths(int m, int n){
//        //Create a 2D table to store results of subproblems
//        int[][] count = new int[m][n];
//
//        //Count of paths to reach any cell in first row is 1
//        for(int i = 0; i < m; i++){
//            count[i][0] = 1;
//        }
//
//        //Count of paths to reach any cell in first column is 1
//        for(int j = 0; j < n; j++){
//            count[0][j] = 1;
//        }
//
//        //Calculate count of paths for other cells in bottom-up
//        //manner using the recursive solution
//        for(int i = 1; i < m; i++){
//            for(int j = 1; j < n; j++){
//                //By uncommenting the last part the code calculates the
//                //total possible paths if the diagonal Movements are allowed
//                count[i][j] = count[i - 1][j] + count[i][j - 1]; // + count [i-1][j-1];
//            }
//        }
//        return count[m - 1][n - 1];
//    }

//    //recursive solution
//    public static int numberOfPaths(int m, int n){
//        //If either given row number is first or given column number is first
//        if(m == 1 || n == 1){
//            return 1;
//        }
//
//        //If diagonal movements are allowed then the last addition is required
//        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
//        // + numberOfPaths(m - 1, n - 1);
//    }
}
