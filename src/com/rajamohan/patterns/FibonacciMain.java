package com.rajamohan.patterns;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciMain {

    static Map<Integer,Long> cacheMap = new HashMap<>();

    // 2/Multi  Recursion method used for Factorial, FragJump and Fibonacci
    static int Fibonacci(int n){
        if(n==1 || n==0){
            return n;
        }
        int left = Fibonacci(n-1);
        int right = Fibonacci(n-2);
        return left+right;
    }

    // This pattern used for grid paths, coin change, etc
    static long FibonacciWithMap(int n){
        if(n ==0 || n==1){
            return n;
        }
        if(cacheMap.containsKey(n)){
            return cacheMap.get(n);
        }
        long result = FibonacciWithMap(n-1)+FibonacciWithMap(n-2);
        cacheMap.put(n, result);
        return result;
    }

    // uses O(1) extra space:
    static long FibonacciWithoutExtraSpace(int n){
        if(n==1 || n==0){
            return n;
        }
        // prev — holds Fibonacci(i-2) relative to the current step
        // curr — holds Fibonacci(i-1) relative to the current step
        // next — computed as prev + curr, which is Fibonacci(i)
        long prev = 0, curr = 1;
        for(int i=2; i<=n; i++){
            long next = prev+curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }


    static BigInteger Factorial(int n){
        /*  Factorial(5) = 5 * Factorial(4)
             = 5 * (4 * Factorial(3))
             = 5 * (4 * (3 * Factorial(2)))
             = 5 * (4 * (3 * (2 * Factorial(1))))
             = 5 * 4 * 3 * 2 * 1
             = 120   */
        if (n==0 || n==1){
            return  BigInteger.ONE;
        }
        // return n * Factorial(n-1); -> Normal factorial since long or int can hold only certain values moved to BigInt
        return  BigInteger.valueOf(n).multiply(Factorial(n-1));
    }

    public static  void main(String[] args){
         int n=100;
         //System.out.println("Fibonacci of (" + n + ")->" + Fibonacci(n));
        //System.out.println("Fibonacci of (" + n + ") with Map implementation->" + FibonacciWithMap(n));
        System.out.println("Fibonacci of (" + n + ") with out extra space and recrusion->" + FibonacciWithoutExtraSpace(n));
        n = 16;
        System.out.println("Factorial of : " + n + "-->" + Factorial(n));
    }
}
