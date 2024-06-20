package LinearDS.arrayProgram.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static int[] sort(int arr[],int n) {
		for(int i=0;i<n-1;i++) {
			int j = i+1;
			while(j>0&&arr[j]<arr[j-1]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		 int[][] arrays = {
		            {},
		            {5},
		            {1, 2, 3, 4, 5},
		            {5, 4, 3, 2, 1},
		            {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5},
		            {-5, 3, -2, 1, -1, 4, -6},
		            {2, 2, 2, 2, 2},
		            {7, 2, 9, 1, 5, 3, 8, 6, 4}
		        };

		        for (int[] array : arrays) {
		            int[] sortedArray = sort(array.clone(),array.length);
		            System.out.println("Original Array: " + Arrays.toString(array) + " --> Sorted Array: " + Arrays.toString(sortedArray));
		        }

	}

}
