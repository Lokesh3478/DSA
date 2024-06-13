package LinearDS.arrayProgram.binarySearchProblems;

public class MountainArray {
	 //Order Agnostic Search 
    
    public int binarySearch(int arr[], int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int middleElement = arr[mid];
        
            if (middleElement == target) {
                return mid;
            }
        
            if (ascending) {
                if (middleElement < target) {
                    start = mid + 1;
                } 
                else {
                    end = mid - 1;
                }
            } 
            else {
                if (middleElement < target) {
                    end = mid - 1;
                } 
                else {
                    start = mid + 1;
                }
            }
        }
    
        return -1;  // Target not found
    }
    
    
    //852. Peak Index in a Mountain Array
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0; int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            
            //currently in increasing part of array,
            //answers may lie on the right side

            if(arr[mid]<arr[mid+1]) start = mid+1;

            //currently in decreasing part of array,
            //answers may lie on left side inclusive of middle element

            else end = mid;
        }
        /*In the end , start==end , both points to the same element which must be the largest 
         * element possible, because both the pointers are looking at the larger side i.e 
         * start shifts right changes if we are in ascending order side , and "end" shifts left changes if we are 
         * in descending order , both ending up pointing the same element which is largest element*/
        return start;
    }
    
    
    //1095.Find in Mountain Array
    //https://leetcode.com/problems/find-in-mountain-array/description/
    
    public int findInMountainArray(int target,int arr[]) {
        // Find the peak index in the mountain array
        int peak = peakIndexInMountainArray(arr);
        
        // Search for the target in the increasing part of the array
        int index = binarySearch(arr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        
        // If the target is not found, search in the decreasing part of the array
        return binarySearch(arr, target, peak + 1, arr.length-1, false);
    }
}
