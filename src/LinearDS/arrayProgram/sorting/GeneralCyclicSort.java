package LinearDS.arrayProgram.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneralCyclicSort {
	public static void cyclicSort(int arr[]) {
		int n = arr.length;
		for(int start = 0;start<n;start++) {
			int key = arr[start];
			int location = start;
			for(int i = start+1;i<n;i++) {
				if(arr[i]<key) {
					location++;
				}
			}
			if(location==start) {
				continue;
			}
			while(arr[location]==key) {
				location++;
			}
			int temp = key;
			key = arr[location];
			arr[location] = temp;
			location = start;
			while(true) {
				for(int i = start+1;i<n;i++) {
					if(arr[i]<key) {
						location++;
					}
				}
				if(location==start) {
					break;
				}
				while(arr[location]==key) {
					location++;
				}
				temp = key;
				key = arr[location];
				arr[location] = temp;
				location = start;
			}
			
			arr[location] = key;
		}
		
	}

	public static void main(String[] args) {
		 ArrayList<int[]> testCases = new ArrayList<>();
	        
//	        testCases.add(new int[]{5, 2, 9, 1, 5, 6});
//	        testCases.add(new int[]{});
//	        testCases.add(new int[]{3});
//	        testCases.add(new int[]{2, 2, 2, 2});
//	        testCases.add(new int[]{9, 7, 5, 3, 1});
//	        testCases.add(new int[]{1, 3, 5, 7, 9});
//	        testCases.add(new int[]{8, 1, 6, 3, 2, 5, 7, 4});
//	        testCases.add(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1});
//	        testCases.add(new int[]{1, -1, 0, -1000, 1000});
//	        testCases.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
	        testCases.add(new int[] {3,1,3,3,3,3,3,3,2});

	        for (int[] testCase : testCases) {
	            System.out.println("Original array: " + Arrays.toString(testCase));
	            cyclicSort(testCase);
	            System.out.println("Sorted array: " + Arrays.toString(testCase));
	            System.out.println();
	        }

	}

}
