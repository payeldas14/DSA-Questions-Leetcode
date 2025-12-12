//Merge Sort - https://leetcode.com/problems/sort-an-array/
//Time Complexity: O(n log n) and Space Complexity: O(n) - O(n) + O(log n) (Depth is O(log n) (since we divide by 2 each time))
import java.util.*;

class solution {
    public void mergeSort(int[] arr) {
        if(arr.length < 2){
            return;
        }

        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];

        for(int i=0; i<mid; i++){
            left[i] = arr[i];
        }

        for(int i=mid; i<arr.length; i++){
            right[i-mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}

