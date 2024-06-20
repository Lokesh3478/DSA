package LinearDS.arrayProgram.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort1toN {

	public static void sort(int arr[],int n) {
		int i =0;
		while(i<arr.length) {
			int correct = arr[i]-1;
			while(correct!=i) {
				int temp = arr[correct];
				arr[correct] = arr[i];
				arr[i] = temp;
				correct = arr[i]-1;
			}
			i++;
		}
	}
	
	//LeetCode 268. Missing Number
	
	public int missingNumber(int[] nums) {
        int i =0;
        while(i<nums.length){
            int correct = nums[i];
            while(nums[i]<nums.length&&nums[i]!=i){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
                correct = nums[i];
            }
            i++;
        }
        for(i =0;i<nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
	
	//LeetCode 448 Find All numbers disappeared in array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i =0;
        while(i<nums.length){
            int correct = nums[i]-1;
            while(correct!=i&&nums[correct]!=nums[i]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
                correct = nums[i]-1;
            }
            i++;
        }
        List<Integer>res = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                res.add(i+1);
            }
        }
        return res;
    }
	//LeetCode 287 Find Duplicate in Array   
    public int findDuplicate(int[] nums) {
        int i =0;
        while(i<nums.length){
            int correct = nums[i]-1;
            while(nums[i]-1!=i){
                if(nums[i]==nums[correct]){
                    System.gc();
                    return nums[i];
                }
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
                correct = nums[i]-1;
            }
            i++;
        }
        return -1;
    }
	    
	//LeetCode 442 Find All Duplicates in the Array
	    
	public List<Integer> findDuplicates(int[] nums) {
		int i =0;
	    while(i<nums.length){
	    	int correct = nums[i]-1;
	    	while(correct!=i&&nums[i]!=nums[correct]){
	    		int temp = nums[correct];
				nums[correct] = nums[i];
				nums[i] = temp;
				correct = nums[i]-1;
			}
				i++;
		}
	    List<Integer>res = new ArrayList<>();
		for(i =0;i<nums.length;i++){
			if(nums[i]!=i+1){
				res.add(nums[i]);
			}
		}
		return res;
	}
	
	//LeetCode 645 Set MisMatch
	public int[] findErrorNums(int[] nums) {
        int i =0;
        while(i<nums.length){
            int correct = nums[i]-1;
            while(nums[i]<=nums.length&&nums[i]-1!=i&&nums[i]!=nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
                correct = nums[i]-1;
            }
            i++;
        }
        for( i =0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1};
    }
	
	public static void main(String[] args) {
		int[][] testCases = {
	            {3, 1, 2},
	            {4, 3, 2, 1},
	            {5, 4, 3, 2, 1},
	            {1, 5, 4, 3, 2},
	            {2, 1, 4, 3, 6, 5}
	        };

	        for (int[] testCase : testCases) {
	            System.out.println("Unsorted: " + Arrays.toString(testCase));
	            sort(testCase,testCase.length);
	            System.out.println("Sorted: " + Arrays.toString(testCase));
	            System.out.println();
	        }

	}

}
