package com.company;

public class Main {

    public static void main(String[] args) {
	    int[][] costs = new int[][]{{1, 2, 3, 4, 5},
                                    {6, 7, 8, 9, 10},
                                    {11, 12, 13, 14, 15}};
        System.out.println("Min Costs are " + minCost(costs));
    }

    public static int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }

        int preMin = 0;
        int preSecndMin = 0;
        int preColor = -1;

        for(int i = 0; i < costs.length; i++){
            int curMin = Integer.MAX_VALUE;
            int curSecndMin = Integer.MAX_VALUE;
            int curColor = -1;
            for(int j = 0; j < costs[0].length; j++){
                costs[i][j] = costs[i][j] + (preColor == j ? preSecndMin : preMin);

                if(costs[i][j] < curMin) {
                    curSecndMin = curMin;
                    curMin = costs[i][j];
                    curColor = j;
                }else if(costs[i][j] < curSecndMin){
                    curSecndMin = costs[i][j];
                }
            }
            preMin = curMin;
            preSecndMin = curSecndMin;
            preColor = curColor;
        }
        return preMin;
    }
}
