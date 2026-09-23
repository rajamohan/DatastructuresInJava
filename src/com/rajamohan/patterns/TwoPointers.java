package com.rajamohan.patterns;
import java.util.Arrays;

public class TwoPointers  {
    // Two pointers pattern will be use when we want to find is there
    // any elements are available in array to find the sum
    // Conditions:
    // Apply on sorted arrays, No dependency for changing the element index
    public static void main(String args[]){
        int a[] = {2, 3, 1, 5, 6, 8, 0 };
        int target  = 14 ;

        Arrays.sort(a);
        int total;
        int starting = 0;
        int ending = a.length-1;

        // When ever we want to use the two pointers its good to use the while loop
        while(starting < ending){
            total = a[starting] + a[ending];
            if(total == target){
                System.out.println(target + " found by adding: " + a[starting] + " and " + a[ending] );
                return;
            }
            if(target > total){
                starting++;
            }
            if(target < total){
                ending--;
            }
        }
    }
}
