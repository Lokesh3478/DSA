package Recursion;
import java.util.ArrayList;
import java.util.Arrays;

public class RecursionArrayLevel1 {
	//Recursion Function to check if sorted
	public boolean isSorted(int arr[], int i, int n, boolean ascending) {
        if (i == n - 1) {
            return true;
        }
        if (ascending) {
            if (arr[i] <= arr[i + 1]) {
                return isSorted(arr, i + 1, n, true);
            }
        } else {
            if (arr[i] >= arr[i + 1]) {
                return isSorted(arr, i + 1, n, false);
            }
        }
        return false;
    }

	//Helper function to invoke recursion
    public boolean sorted(int arr[]) {
        int n = arr.length;
        if (n <= 2) return true; 
  
        
        boolean ascending = arr[0] <= arr[1];
        return isSorted(arr, 1, n, ascending);
    }
    
	
    //Linear Search - recursion 
    public ArrayList<Integer> linearSearch(int arr[],int target,int i,int n){
    	ArrayList<Integer>list = new ArrayList<Integer>();
    	if(i== n) {
    		return list;
    	}
    	if(arr[i]==target) {
    		list.add(i);
    	}
    	list.addAll(linearSearch(arr, target,i+1,n));
    	return list;
    }
    
    //Binary Search - recursion
    public int binarySearch(int arr[],int target,int s, int e) {
    	if(s>e) {
    		return -1;
    	}
    	int mid = s+(e-s)/2;
    	if(arr[mid]==target) {
    		return mid;
    	}
    	else if(arr[mid]>target) {
    		return binarySearch(arr, target, s, mid-1);
    	}
    	return binarySearch(arr, target, mid+1, e);
    }
    
    //BubbleSort
    public static void bubbleSort(int arr[],int i,int j) {
    	if(i>=arr.length) {
    		return;
    	}
    	if(j>=arr.length-i-1) {
    		bubbleSort(arr, i+1, 0);
    		return;
    	}
    	if(arr[j]>arr[j+1]) {
    		int swap = arr[j+1];
    		arr[j+1] = arr[j];
    		arr[j] = swap;
    	}
    	bubbleSort(arr,i,j+1);
    }
    
    //Selection sort
    public static void selectionSort(int arr[],int i, int max,int j) {
    	if(i>=arr.length) {
    		return;
    	}
    	if(j>arr.length-i-1) {
    		int temp = arr[arr.length-i-1];
    		arr[arr.length-i-1] = arr[max];
    		arr[max] = temp;
    		selectionSort(arr, i+1, max, 0);
    		return;
    	}
    	max = arr[max]>arr[j]?max:j;
    	selectionSort(arr,i,max,j+1);
    }
    
    //LeetCode problems
    
    	//852. Peak Index in a Mountain Array https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    
        public int peakIndexInMountainArray(int[] arr) {
            return helperForPeak(arr,0,arr.length-1);
        }
        //helper method
        public int helperForPeak(int[] arr,int s,int e){
            if(s>=e){
                return s;
            }
            int mid = s+(e-s)/2;
            if(arr[mid]<arr[mid+1]){
               return helperForPeak(arr,mid+1,e);
            }
            return helperForPeak(arr,s,mid);
            
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
     	     
     	     
    
	public static void main(String[] args) {
		RecursionArrayLevel1 obj = new RecursionArrayLevel1();
		int arr[] = new int[] {
				2, 5, 7, 3, 4, 8, 1, 64,849,3,5,7,75,353,64,54,35,32,35,2452,543,6,4352,433,5334, 9, 2, 3, 8, 7, 5, 4, 9, 1, 6, 3, 2, 5, 8, 4, 7, 1, 6, 9, 2, 5, 3, 1, 7, 8, 6, 9, 4, 2, 3, 1, 8, 5, 7, 4, 2, 6, 9, 3, 2, 7, 4
		};
		ArrayList<Integer>indices = obj.linearSearch(arr, 3,0,arr.length);
		System.out.println(indices);
		selectionSort(arr, 0,0,0);
		System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,12};
        int result1 = obj.binarySearch(arr1, 12,0,arr1.length-1);
        System.out.println("Test Case 1 Result: " + result1); 

	}

}
