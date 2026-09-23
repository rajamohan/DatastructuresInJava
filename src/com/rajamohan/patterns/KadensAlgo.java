package com.rajamohan.patterns;

public class KadensAlgo {
    public static void main(String[] args ){
    //int a[] = {2, 3, -8, 7, -1, 2, 3 };
    int a[] = {-2, -4};
    //int a[] = {5, 4, 1, 7, 8};

    int max = Integer.MIN_VALUE;
    int sum =  0 ;
    for(int i = 0; i<a.length; i++){
        sum = sum + a[i];
        if(sum > max) {
            max = sum;
        }
        if(sum < 0){
            sum = 0;
        }
    }
    System.out.println(max);
    }
}