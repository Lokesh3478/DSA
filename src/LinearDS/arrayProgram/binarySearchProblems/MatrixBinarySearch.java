package LinearDS.arrayProgram.binarySearchProblems;




public class MatrixBinarySearch {
	//Row wise and Column wise started
	public int[] Binarysearch(int arr[][],int target,int r,int c) {
		int i = 0,j=c-1;
		while(i<r&&c>=0) {
			int element = arr[i][j];
			if(element==target) return new int[] {r,c};
			/*If the target is greater than element , we should increase the row
			 * as we are starting from lower bound and we are at maximum element of that row
			 * we should increase the row , there is no way it will be in that row*/
			else if(element<target) {
				r++;
			}
			
			/*If the target is lesser than element , we should decrease the column , as we are the first
			 * element of that column,there is no way it will be in that column as we are the minimum element 
			 * of that column 
			 * */
			
			else {
				c--;
			}
		}
		return new int[] {-1,-1};
	}
	
	/*You are given an m x n integer matrix matrix with the following two properties:
	 * Each row is sorted in non-decreasing order.
	 * The first integer of each row is greater than the last integer of the previous row.*/
	    public int[] searchMatrix(int[][] matrix, int target) {
	        int start =0; int end = matrix.length-1;
	        /*Since the first element of each row is greater than last element of previous element ,
	         * It is advisable to find a row that has the nearest smaller number to target or target itself 
	         * at the first position
	         * Find the floor of the target 
	         * */
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            int ele = matrix[mid][0];
	            if(ele==target) {
	            	return new int[] {mid,0};
	            }
	            else if(ele>target) { 
	            	end=mid-1;
	            }
	            else start = mid+1;
	        }
	        /*After finding the floor, we can search within that row to get
	         * target*/
	        if(end==-1) return new int[] {-1,-1};
	        int row =end;
	        start=0; end = matrix[start].length-1;
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            int ele = matrix[row][mid];
	            if(ele==target) {
	            	return new int[] {row,mid};
	            }
	            else if(ele>target) {
	            	end=mid-1;
	            }
	            else start = mid+1;
	        }
	        return new int[] {start,end};
	    }
	
}
