//34. Find First and Last Position of Element in Sorted Array - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// time = O(logn) and space = O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, true, target);

        if(first == -1){
            return new int[]{-1, -1};
        }

        int last = findIndex(nums, false, target);
        return new int[]{first, last};
    }

    private int findIndex(int[] nums, boolean isFirst, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] ==  target){
                if(isFirst){
                    if(mid == start || nums[mid] != nums[mid-1]){
                        return mid;
                    }
                    end = mid - 1;
                }else{
                    if(mid == end || nums[mid] != nums[mid+1]){
                        return mid;
                    }
                    start = mid + 1;
                }
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}