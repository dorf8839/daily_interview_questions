package com.company;

public class Main {

    public static final int INTERVAL = 10000;

    public static void main(String[] args) {
        int i, circlePoints = 0, squarePoints = 0;
        double randX, randY, originDist, pi;

        for(i = 0; i < (INTERVAL*INTERVAL); i++){
            //Randomly generated x and y values
            randX = Math.random();
            randY = Math.random();
            //Calculating distance between (x,y) and the origin
            originDist = randX * randX + randY * randY;
            //Checking if the point lies within the circle
            if(originDist <= 1){
                circlePoints++;
            }
            //Total number of points generated
            squarePoints++;
        }
        //Estimating pi after all points are placed
        pi = (double)(4 * circlePoints)/squarePoints;
        System.out.println("Final estimation for Pi = " + pi);
    }
}
