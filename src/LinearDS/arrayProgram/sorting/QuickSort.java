package LinearDS.arrayProgram.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void quicksort(int s,int e,int arr[]) {
		if(s<=e) {
			int pivot = partition(s,e,arr);
			quicksort(s,pivot-1, arr);
			quicksort(pivot+1,e, arr);
		}

	}
	public static int partition(int s,int e,int arr[]) {
		int mid = s+(e-s)/2;
		int pivot = arr[s];
		int low = s,high = e;
		while(s<e) {
			while(s<=e&&arr[s]<=pivot) s++;
			while(e>=s&&arr[e]>pivot) e--;
			if(s<=e) {
				int swap = arr[e];
				arr[e] = arr[s];
				arr[s] = swap;
			}
		}
		int temp = arr[e];
		arr[e] = arr[low];
		arr[low]= temp;
		return e;
	}
	public static void main(String[] args) {
		int arr[] = new int[] {180,165,170};
		quicksort(0, arr.length-1, arr);
		System.out.println(Arrays.toString(arr));
	}
}
