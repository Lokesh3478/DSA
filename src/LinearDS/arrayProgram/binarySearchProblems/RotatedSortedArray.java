package LinearDS.arrayProgram.binarySearchProblems;

public class RotatedSortedArray {
	/**
	 * This function finds the pivot element in a rotated sorted array without duplicates.
	 * The pivot element is the largest element in the array, which is where the rotation occurs.
	 * The approach uses binary search to efficiently locate the pivot. By comparing the mid element
	 * with its neighbors, we determine if it is the pivot. Additionally, by comparing the mid element
	 * with the start element, we decide which half of the array to search next.
	 * This ensures we always move towards the unsorted part of the array where the pivot lies.
	 */
	public static int findPivotElement(int[] nums) {
	    int start = 0;
	    int end = nums.length - 1;
	    int n = end + 1; // Total number of elements in the array
	    
	    // Binary search loop to find the pivot element
	    while (start < end) {
	        int mid = start + (end - start) / 2; // Calculate the middle index

	        // Check if the middle element is the pivot element
	        if (nums[mid % n] > nums[(mid + 1) % n]) {
	            // If the middle element is greater than the next element,
	            // then the middle element is the pivot
	            return mid;
	        } 
	        // Check if the element before the middle is the pivot element
	        else if (nums[mid % n] < nums[(mid - 1 + n) % n]) {
	            // If the middle element is less than the previous element,
	            // then the previous element is the pivot
	            return (mid - 1 + n) % n;
	        } 
	        // If the start element is greater than the middle element, 
	        // the pivot must be in the left half of the array
	        else if (nums[start % n] > nums[mid % n]) {
	            // The right half is sorted because no element in the right half
	            // can be greater than the start element
	            end = mid - 1; // Narrow down the search range to the left half
	        } 
	        // If the start element is less than or equal to the middle element,
	        // the pivot must be in the right half of the array
	        else {
	            // The left half is sorted, so the pivot must be in the right half
	            start = mid + 1; // Narrow down the search range to the right half
	        }
	    }

	    // Return the result (this case may happen when the array is not rotated)
	    return -1;
	}
	/**This method finds the pivot element in a rotated sorted array with duplicate values 
	 * In a rotated sorted array , if the pointers points to the same value we need to shrink 
	 * the search space after checking if the start and end elements are pivot by comparing 
	 * with the adjacent elements , if any two elements have same value , then go for the one 
	 * with unsorted elements as in non duplicate approach
	 * */
	 public int pivot(int[] nums){
	        int start = 0; int end = nums.length-1; int n = nums.length;
			while(start<=end) {
				int mid = start+(end-start)/2;
	            if(mid<end&&nums[mid]>nums[mid+1]) {
	            	return mid;
	            }
	            else if(mid>0&&nums[mid]<nums[mid-1]) {
	            	return mid-1;
	            }
				else if(nums[start]==nums[mid]&&nums[mid]==nums[end]) {
					if(start<end&&nums[start]>nums[start+1]) { 
						return start;
					}
					start++;
					if(end>0&&nums[end]<nums[end-1]) {
						return end;
					}
					end--;
				}
				else if(nums[start]<nums[mid]||nums[start]==nums[mid]&&nums[mid]>nums[end]) {
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
			return 0;
	}
	 /**
	  * This method finds the pivot element in a rotated sorted array with duplicate values.
	  * In a rotated sorted array, if the pointers point to the same value, we need to shrink
	  * the search space after checking if the start and end elements are pivot points by comparing
	  * them with the adjacent elements. If any two elements have the same value, then go for the half
	  * with unsorted elements as in the non-duplicate approach.
	  */
	 public int pivotWithDuplicates(int[] nums) {
	     int start = 0; 
	     int end = nums.length - 1; 

	     while (start <= end) { 
	         int mid = start + (end - start) / 2; 

	         // Check if mid is the pivot point by comparing it with the next element
	         if (mid < end && nums[mid] > nums[mid + 1]) {
	             return mid; // Mid is the pivot point
	         }
	         // Check if the previous element to mid is the pivot point
	         else if (mid > 0 && nums[mid] < nums[mid - 1]) {
	             return mid - 1; // Previous element to mid is the pivot point
	         }
	         // Handle the case where elements at start, mid, and end are equal
	         else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
	             // Check if the element at start is the pivot point
	             if (start < end && nums[start] > nums[start + 1]) {
	                 return start; // Start is the pivot point
	             }
	             start++; // Increment start to move past duplicates
	             // Check if the element at end is the pivot point
	             if (end > 0 && nums[end] < nums[end - 1]) {
	                 return end; // End is the pivot point
	             }
	             end--; // Decrement end to move past duplicates
	         }
	         // If left half is sorted or has duplicates at the boundary, pivot is in the right half
	         else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
	             start = mid + 1; // Pivot is in the right half
	         }
	         // Otherwise, the pivot is in the left half
	         else {
	             end = mid - 1; // Pivot is in the left half
	         }
	     }
	     return 0; // Return 0 if no pivot is found (array might not be rotated)
	 }

	public static void main(String[] args) {
        int[][] testCases = {
            {5}, // Peak: 5
            {3, 5}, // Peak: 5
            {5, 3}, // Peak: 5
            {4, 5, 6, 1, 2, 3}, // Peak: 6
            {6, 1, 2, 3, 4, 5}, // Peak: 7
            {10, 8, 6, 4, 2}, // Peak: 10
            {2, 4, 6, 8, 10}, // Peak: 10
            {1, 3, 20, 4, 1, 0}, // Peak: 20
            {13, 18, 25, 2, 8, 10}, // Peak: 25
            {9, 7, 5, 3, 1}, // Peak: 9
            {1, 3, 5, 7, 9} // Peak: 9
        };
        
        for (int[] testCase : testCases) {
            System.out.println("Peak element in array " + java.util.Arrays.toString(testCase) + ": " + findPivotElement(testCase));
        }
    }

}

//Thread
