package LinearDS.arrayProgram;

import java.util.Arrays;

public class ArraySearch {
	//TC O(n) SC O(1)
	public int linearSearch(int arr[],int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) return i;
		}
		return -1;
	}
	//TC O(log2n) SC O(1) 
	public int binarySearch(int left,int right,int arr[],int target) {
		if(left>right) return -1;
		int mid = left + (right-left)/2;
		if(arr[mid]==target) return mid;
		else if(arr[mid]>target) { return binarySearch(left, mid-1, arr,target); }
		return binarySearch(mid+1, right, arr,target);
	}
	//Modified Binary Search returns largest number smaller than or equal to target 
	public int floor(int left,int right,int arr[],int target) {
		if(left>right) return right;
		int mid = left + (right-left)/2;
		if(arr[mid]==target) return mid;
		else if(arr[mid]>target) { return floor(left, mid-1, arr,target); }
		return floor(mid+1, right, arr,target);
	}
	//Modified Binary Search returns smallest number greater than or equal to target
	public int ceil(int left,int right,int arr[],int target) {
		if(left>right) return left;
		int mid = left + (right-left)/2;
		if(arr[mid]==target) return mid;
		else if(arr[mid]>target) { return ceil(left, mid-1, arr,target); }
		return ceil(mid+1, right, arr,target);
	}
     public static void main(String[] args) {
		int arr[] = new int[] {1,3,6,13,45,67,77,89,90,234,566,771,891};
		Arrays.sort(arr);
		ArraySearch as = new ArraySearch();
		System.out.println(as.linearSearch(arr, 44));
		System.out.println(as.binarySearch(0, arr.length-1, arr, 44));
		System.out.println(as.ceil(0, arr.length-1, arr, 100));
		System.out.println(as.floor(0, arr.length-1, arr, 100));
	}
}
