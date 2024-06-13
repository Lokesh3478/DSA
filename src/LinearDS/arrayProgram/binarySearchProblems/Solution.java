package LinearDS.arrayProgram.binarySearchProblems;

public class Solution {
       //LeetCode 744. Find Smallest Letter Greater Than Target
	   //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
	   public char nextGreatestLetter(char[] letters, char target) {
	        int index = binarySearch(letters,target,0,letters.length-1);
	        System.gc();
	        return letters[index%letters.length];
       }
	   
       public int binarySearch(char[]arr,char a,int left , int right){
	        if(left>right) return left;
	        int mid = left + (right-left)/2;
	        if(arr[mid]>a)return binarySearch(arr,a,left,mid-1);
	        return binarySearch(arr,a,mid+1,right);
       }
       
       //34. Find First and Last Position of Element in Sorted Array
       //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    	    public int[] searchRange(int[] nums, int target) {
    	        int firstIndex = firstOccurence(nums,target,0,nums.length-1,-1);
    	        int lastIndex = lastOccurence(nums,target,0,nums.length-1,-1);
    	        return new int[]{firstIndex,lastIndex};
    	    }
    	    public int firstOccurence(int[] nums,int target,int left,int right,int ans){
    	        if(left>right) return ans;
    	        int mid = left+(right-left)/2;
    	        if(nums[mid]<target) return firstOccurence(nums,target,mid+1,right,ans);
    	        else if(nums[mid]>target) return firstOccurence(nums,target,left,mid-1,ans);
    	        return firstOccurence(nums,target,left,mid-1,mid);
    	    }
    	     public int lastOccurence(int[] nums,int target,int left,int right,int ans){
    	        if(left>right) return ans;
    	        int mid = (left+right)/2;
    	        if(nums[mid]<target) return lastOccurence(nums,target,mid+1,right,ans);
    	        else if(nums[mid]>target)return lastOccurence(nums,target,left,mid-1,ans);
    	        return lastOccurence(nums,target,mid+1,right,mid);
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
