package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int ROW = 4;
    static int COL = 4;
    //These arrays are used to get row and column numbers of 4 neighbors of a given cell
    static int[] rowNum = {-1, 0, 0, 1};
    static int[] colNum = {0, -1, 1, 0};

    //to store matrix cell coordinates
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //A data structure for queue used in BFS
    static class queueNode{
        Point pt;
        int dist;

        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }

    //Check whether given cell (row, col) is valid cell or not
    static boolean isValid(int row, int col){
        //return true if row number and column number is in range
        return (row >= 0) && (row < ROW) && (col >=0) && (col < COL);
    }

    //Function to find the shortest path between a given source cell to a destination cell
    static int BFS(char[][] mat, Point src, Point dest){
        //Check if source and destination cell of the matrix have value f
        if(mat[src.x][src.y] != 'f' || mat[dest.x][dest.y] != 'f'){
            return -1;
        }

        boolean[][] visited = new boolean[ROW][COL];

        //Mark the source cell as visited
        visited[src.x][src.y] = true;

        //Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();

        //Distance of source cell is 0
        queueNode s = new queueNode(src, 0);
        q.add(s); //Enqueue source cell

        //Do a BFS starting from source cell
        while(!q.isEmpty()){
            queueNode curr = q.peek();
            Point pt = curr.pt;

            //If we have reached the destination cell, we are done
            if(pt.x == dest.x && pt.y == dest.y){
                return curr.dist;
            }

            //Otherwise, dequeue the front cell and enqueue its adjacent cells
            q.remove();

            for(int i = 0; i < 4; i++){
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                //if adjacent cell is valid, has path, and not visited yet, enqueue it
                if(isValid(row, col) && mat[row][col] == 'f' && !visited[row][col]){
                    //mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode adjCell = new queueNode(new Point(row, col), curr.dist + 1);
                    q.add(adjCell);
                }
            }
        }

        //Return -1 if destination can not be reached
        return -1;
    }

    public static void main(String[] args) {
        char[][] mat = { {'f', 'f', 'f', 'f'},
                        {'t', 't', 'f', 't'},
                        {'f', 'f', 'f', 'f'},
                        {'f', 'f', 'f', 'f'}};

        Point source = new Point(3, 0);
        Point dest = new Point(0, 0);

        int dist = BFS(mat, source, dest);

        if (dist != -1)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }
}
