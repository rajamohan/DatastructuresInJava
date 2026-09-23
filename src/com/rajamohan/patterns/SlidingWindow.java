package com.rajamohan.patterns;

import java.util.HashMap;

class  FixedWindowSize{
    public int returnK(int array[], int k){
        int windowSum = 0; int windowMax = 0;

        for(int i=0; i<k; i++){
            windowSum = windowSum + array[i];
        }

        windowMax = windowSum;
// Key idea: instead of recomputing the sum of each window from scratch (O(n·k)), you just subtract the element leaving the window and add the element entering it — O(n) total.
        for(int i=k; i<array.length; i++){
            windowSum = windowSum + array[i] - array[i-k];
            windowMax = Math.max(windowMax, windowSum);
        }
        return  windowMax;
    }
}

class VariableWindow {
    public int minSubArrayLength(int[] array, int target){
        int left=0, sum =0, minLength = Integer.MAX_VALUE;
        // Key idea: right always moves forward to expand the window; left only moves forward when the window becomes "too much" (here, sum big enough),
        // so each pointer moves at most n times — still O(n) overall despite the nested loop.
        for(int right = 0;  right < array.length; right++){
            sum += array[right]; // Expand the window
            while(sum >= target){ // shrink while condition holds
                minLength = Math.min(minLength, right - left + 1);
                sum -= array[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

// Longest sub-string without repeating
class LongestSubString{
    public int longStringCharLength(String s){
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int left =0, maxLength=0;
        // abcabcbb
        for(int right =0; right<s.length(); right++){
            char c = s.charAt(right);
            if(lastSeen.containsKey(c) && lastSeen.get(c) >= left){
                left = lastSeen.get(c)+1;
            }
            lastSeen.put(c, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return  maxLength;
    }
}

public class SlidingWindow {
 // When ever user ask to find the max/min total of k elements with +ve number this pattern will work
    public static void main(String[] args){
        int a[] =  {2, 1, 5, 1, 3, 2};
        int k = 3; // Max element to make largest sum
        FixedWindowSize fixedWindowSize = new FixedWindowSize();
        System.out.println("Max sum of sub array : " + fixedWindowSize.returnK(a, k));

        // Min no of elements need to target the K
        VariableWindow variableWindow = new VariableWindow();
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println("Min no of elements required for sum : " +variableWindow.minSubArrayLength(arr, 7));

        // Max no of character which will make string without repeat char
        LongestSubString longSubStr = new LongestSubString();
        System.out.println("Longest sub str length : " + longSubStr.longStringCharLength("Rajamohan Sugumaran")); // "mohansugu : 9"
        System.out.println("Longest sub str length : " + longSubStr.longStringCharLength("abcabcbb")); // 3 ("abc")
    }
}
