package LinearDS.arrayProgram.sorting;

import java.util.Arrays;

public class SelectionSort {
	public void SelectMin(int nums[],int n) {
		for(int i =0;i<nums.length-1;i++) {
			int min = i;
			for(int j = i+1;j<nums.length;j++) {
				min = nums[j]<nums[min]?j:min;
			}
			int temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
			
		}
	}
	public void SelectMax(int nums[],int n) {
		for(int i =nums.length-1;i>=0;i--) {
			int max = i;
			for(int j = 0;j<=i;j++) {
				max = nums[j]>nums[max]?j:max;
			}
			int temp = nums[i];
			nums[i] = nums[max];
			nums[max] = temp;
			
		}
	}
	public static void main(String[] args) {
		int arr[] = {84, 19, 63, 14, 46, 33, 93, 22, 48, 97, 72, 7, 56, 12, 66, 80, 24, 39, 88, 54, 25, 3, 49, 11};
		SelectionSort s = new SelectionSort();
		s.SelectMin(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		int arr2[] = {5, 3, 8, 5, 2, 8, 7, 4, 3, 5, 2, 7, 9, 3, 5, 8, 2, 5, 7, 4, 5, 3, 8, 2, 9};
		s.SelectMax(arr2, arr2.length);
		System.out.println(Arrays.toString(arr2));

		

	}

}
