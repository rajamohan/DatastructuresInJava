package com.rajamohan.base;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a[] = {10,20,30,45,55,88,99,101,896,999,1200,1400,1593,2358,3555};

        System.out.println("Enter the key:");
        int key = sc.nextInt();

        int lowBound = 0;
        int upperBound = a.length-1;
        boolean flag = false;

        while(lowBound<=upperBound){
            int mid = (lowBound+upperBound)/2;
            if(key==a[mid]){
                System.out.println("Key found at : " + mid);
                flag = true;
                break;
            }
            else if(a[mid] > key){
                upperBound = mid -1;
            }else {
                lowBound = mid + 1;
            }
        }

        if(!flag){
            System.out.println("Key not found");
        }
    }

}
