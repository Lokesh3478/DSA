package LinearDS.arrayProgram;
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
     public static void main(String[] args) {
		int arr[] = new int[] {3,44,2221,443,11,42,66,2,5,1,5,2};
		ArraySearch as = new ArraySearch();
		System.out.println(as.linearSearch(arr, 44));
		System.out.println(as.binarySearch(0, arr.length, arr, 44));
	}
}
