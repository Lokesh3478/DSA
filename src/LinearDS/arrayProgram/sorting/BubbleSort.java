package LinearDS.arrayProgram.sorting;

public class BubbleSort {
	public void sort(int nums[],int n) {
		for(int i =0;i<n;i++) {
			boolean swap = false;
			for(int j=0;j<n-1;j++) {
				if(nums[j]>nums[j+1]) {
					swap = true;
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			if(!swap) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		//DriverCode

	}

}
