package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	 int n = 6;
	 int x = 12;
//	 int n = 6;
//	 int x = 36;
	 System.out.println(frequencyCounter(n, x));
    }

    private static int[][] tableGenerator(int n){
        int[][] table = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }

    //Simple Math
    private static int frequencyCounter(int n, int x){
        int count = 0;
        for(int i = 0; i < n; i++){
            if((x % (i+1) == 0) && (x / (i+1) <= n)){
                count++;
            }
        }
        return count;
    }

//    //Brute Force
//    private static int frequencyCounter(int n, int x){
//        int[][] table = tableGenerator(n);
//        int count = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(table[i][j] == x){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}
