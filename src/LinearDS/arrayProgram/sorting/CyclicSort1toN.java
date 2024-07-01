package LinearDS.arrayProgram.sorting;
//Runtime
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
	
	
	//LeetCode 41 First Missing Positive
	
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i =0;
        // Place each number in its correct position if possible
        while(i<n){
        	//Ignore duplicates , number out of bound between 1 to array.length 
        	//Swap till correct index 
            while(nums[i]>0&&nums[i]<=n&&nums[i]-1!=i&&nums[nums[i]-1]!=nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        // Find the first position where the index + 1 doesn't match the value
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all positions are correct, the missing number is n + 1
        return n + 1;
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
