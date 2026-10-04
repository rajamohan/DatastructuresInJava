package com.rajamohan.problem;

import java.net.StandardSocketOptions;

public class FrogJumpMain {

    static int findMinCost(int[] heights){

        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;

        /*
             Position:   0    1    2    3
             Height:    10   20   30   10
             dp[]:       0   10   20   20
        */

        for(int i=1;i<n; i++){
            int oneStep = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int twoSteps = Integer.MAX_VALUE;
            if(i>1){
                twoSteps = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(oneStep,twoSteps);
        }
            return dp[n-1];

    }


    public static void main(String[] args){

        int a[] = {10,20,30,10};
        System.out.println("Min cost to reach nth element " + findMinCost(a));

    }


}
