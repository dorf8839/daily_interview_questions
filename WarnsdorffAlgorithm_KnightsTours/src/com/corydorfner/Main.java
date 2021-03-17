package com.corydorfner;

import java.util.concurrent.ThreadLocalRandom;

//Java program for Knight's Tour problem using Warnsdorff's algorithm
public class Main {

    public static final int N = 8;

    //Move pattern on basis of the change of
    //x coordinates and y coordinates respectively
    public static final int[] cx = {1,1,2,2,-1,-1,-2,-2};
    public static final int[] cy = {2,-2,1,-1,2,-2,1,-1};

    //Function restricts the knight to remain within the 8x8 chessboard
    static boolean limits(int x, int y){
        return ((x >= 0 && y >= 0) && (x < N && y < N));
    }

    //Checks whether the square is valid and empty or not
    static boolean isEmpty(int[] a, int x, int y){
        return (limits(x, y)) && (a[y * N + x] < 0);
    }

    //Returns the number of empty squares adjacent to (x,y);
    static int getDegree(int[] a, int x, int y){
        int count = 0;
        for(int i = 0; i < N; i++){
            if(isEmpty(a, (x + cx[i]), (y + cy[i]))){
                count++;
            }
        }
        return count;
    }

    //Picks next point using Warnsdorff's heurisitic. Returns false
    //if it is not possible to pick next point
    static Cell nextMove(int[] a, Cell cell){
        int min_deg_idx = -1, c, min_deg = (N + 1), nx, ny;

        //Try all N adjacent of (*x, *y) starting from a random
        //adjacent.  Find the adjacent with minimum degree
        int start = ThreadLocalRandom.current().nextInt(1000) % N;
        for(int count = 0; count < N; count++){
            int i = (start + count) % N;
            nx = cell.x + cx[i];
            ny = cell.y + cy[i];
            if((isEmpty(a, nx, ny)) && (c = getDegree(a, nx, ny)) < min_deg){
                min_deg_idx = i;
                min_deg = c;
            }
        }

        //IF we could not find a next cell
        if(min_deg_idx == -1){
            return null;
        }

        //Store coordinates of next point
        nx = cell.x + cx[min_deg_idx];
        ny = cell.y + cy[min_deg_idx];

        //Mark next move
        a[ny * N + nx] = a[(cell.y) * N + (cell.x)] + 1;

        //Update next point
        cell.x = nx;
        cell.y = ny;

        return cell;
    }

    //Displays the chessboard with all the legal knight's moves
    static void print(int[] a){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(a[j * N + i] > count){
                    count = a[j * N + i];
                }
                System.out.printf("%d\t", a[j * N + i]);
            }
            System.out.printf("\n");
        }
        System.out.println("Number of Knight's Tours = " + count);
    }

    //Checks its neighboring squares.  If the knight ends on a square that
    //is one knight's move from the beginning square, then tour is closed
    static boolean neighbor(int x, int y, int xx, int yy){
        for(int i = 0; i < N; i++){
            if (((x + cx[i]) == xx) && ((y + cy[i]) == yy)){
                return true;
            }
        }
        return false;
    }

    //Generates the legal moves using Warnsdorff's
    //heuristics.  Returns false if not possible
    static boolean findClosedTour(){
        //Filling the chessboard matrix with -1's
        int[] a = new int[N*N];
        for(int i = 0; i < N*N; i++){
            a[i] = -1;
        }

        //initial position
        int sx = 3;
        int sy = 2;

        //Current points are same as initial points
        Cell cell = new Cell(sx, sy);

        a[cell.y * N + cell.x] = 1; //Mark first move

        //Keep picking next points using Warnsdorff's heuristic
        Cell ret = null;
        for(int i = 0; i < N * N -1; i++){
            ret = nextMove(a, cell);
            if (ret == null) {
                return false;
            }
        }

        //Check if tour is closed (Can end at starting point)
        if(!neighbor(ret.x, ret.y, sx, sy)){
            return false;
        }

        print(a);
        return true;
    }

    public static void main(String[] args) {
        //While we don't get a solution
        while(!findClosedTour()){
        }
    }
}

class Cell{
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
