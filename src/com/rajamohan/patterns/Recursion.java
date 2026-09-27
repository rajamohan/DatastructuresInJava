package com.rajamohan.patterns;

public class Recursion {
    static void fun(int n){
            if(n ==11){ // base condition
                return;
            }
            System.out.println(n); //operation
            fun(n+1); // recursion call
    }
    // Recursion method with parameterized
    static int funWithParam(int[] arr, int sum, int i){
        if (i == arr.length){
            return sum;
        }
        return funWithParam(arr, sum+arr[i], i+1);
    }

    // functional recursion
    static int functionalRecursion(int[] array, int i ){
        if(i==array.length){
            return 0;
        }
        return functionalRecursion(array, i+1) + array[i];

    }

    public static void main(String args[]){
            int n = 1;
            //fun(n);
            int[] arr={2,1,3,4,7};
            int sum=0, i =0;
            System.out.println("Recursion fun with parameter: " + funWithParam(arr,sum,i));
            System.out.println("Functional recursion: " + functionalRecursion(arr, 0));
    }
}
