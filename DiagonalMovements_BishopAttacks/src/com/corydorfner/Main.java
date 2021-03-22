package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    int[][] bishops = {{0,0},{1,2},{2,2},{4,0}};
	    int[][] board = new int[5][5];
        System.out.println(bishopAttacks(board, bishops));
    }

    public static int bishopAttacks(int[][] board, int[][] bishops){
//        create calculation to determine the difference between x and y coordinates for each pair
//        if the absolute differences are the same between x and y, the bishops can attack eachother
        int count = 0;
        if(bishops.length < 2){
            return 0;
        }
        for(int i = 0 ; i < bishops.length - 1; i++){
            if(bishops[i][0] >= board.length || bishops[i][1] >= board.length || bishops[i][0] < 0 || bishops[i][1] < 0){
                return -1;
            }
            for(int j = i+1; j < bishops.length; j++){
                if(Math.abs(bishops[i][0] - bishops[j][0]) == Math.abs(bishops[i][1] - bishops[j][1])){
                    count++;
                }
            }
        }
        return count;
    }
}
