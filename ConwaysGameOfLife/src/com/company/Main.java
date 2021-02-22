package com.company;

public class Main {

    public static void main(String[] args) {
        int M = 10;
        int N = 10;

        //Initializing the grid
        int[][] grid = {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

        //Displaying the grid
        System.out.println("Original Generation");
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 0){
                    System.out.print(".");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }

    //Function to print next generation
    static void nextGeneration(int[][] grid, int M, int N){
        int[][] future = new int[M][N];

        //Loop through every cell
        for(int l = 1; l < M - 1; l++){
            for(int m = 1; m < N - 1; m++){
                //finding no of neighbors that are alive
                int aliveNeighbors = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        aliveNeighbors += grid[l+i][m+j];
                    }
                }

                //The cell needs to be subtracted from its neighbors as it was counted before
                aliveNeighbors -= grid[l][m];

                //Implementing the Rules of Life

                //Cell is lonely and dies
                if((grid[l][m] == 1) && (aliveNeighbors < 2)){
                    future[l][m] = 0;
                //Cell dies due to over population
                }else if ((grid[l][m] == 1) && (aliveNeighbors > 3)){
                    future[l][m] = 0;
                //A new cell is born
                }else if ((grid[l][m] == 0) && (aliveNeighbors == 3)){
                    future[l][m] = 1;
                //Remains the same
                }else {
                    future[l][m] = grid[l][m];
                }
            }
        }
        System.out.println("Next Generation");
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(future[i][j] == 0){
                    System.out.print(".");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
