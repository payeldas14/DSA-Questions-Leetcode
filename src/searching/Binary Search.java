//704. Binary Search - https://leetcode.com/problems/binary-search/
//Time Complexity: O(log n) and Space Complexity: O(1)

import java.util.*;

class solution {
    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
