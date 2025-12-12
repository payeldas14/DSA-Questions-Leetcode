//Bubble Sort - https://leetcode.com/problems/sort-an-array/
//Time Complexity: O(n^2) and Space Complexity: O(1)

import java.util.*;

class solution {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;

        // Outer loop: number of passes
        for(int i=0; i<n-1; i++){

            // Inner loop: compare adjacent elements
            // After each pass, last i elements are already sorted  
            for(int j=0; j<n-i-1; j++){

                // Compare adjacent elements
                if(nums[j] > nums[j+1]){

                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}

