package LinearDS.arrayProgram.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int arr[]) {
		mergeSort(arr,0,arr.length-1);
	}
	public static void mergeSort(int arr[],int start,int end) {
		if(start>=end) {
			return;
		}
		int mid = start+(end-start)/2;
		mergeSort(arr, start,mid );
		mergeSort(arr, mid+1, end);
		merge(arr,start,mid,end);
	}
	public static void merge(int arr[],int start,int mid,int end){
		int i,j,k;
		i=start; j = mid+1; k=0;
		int merge[] = new int[end-start+1];
		while(i<end) {
			if(arr[i]<arr[j]) {
				i++;
			}
			else {
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
				i++;
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr,start,end+1)));
		
		
	}
	public static void main(String[] args) {
		int arr[] = new int[] {1,4,6,22,5,55,63,63,4,34,5,90,1,5,1};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr)+"LL");
	}
}
