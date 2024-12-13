package LinearDS.stackProgram.monotonicstack;

import LinearDS.stackProgram.implementations.LinkedStack;

public class MonotonicStack {
	public boolean range(int ele,int min,int max){
		return ele>=min&&ele<=max;
	}
	/*Finding Next Greater Element
	**/
	public int[] nextGreaterElement(int[] nums1) {	    
		int n1 = nums1.length;
		LinkedStack ms = new LinkedStack();	       
		ms.push(nums1[n1-1]);
		int nge[] = new int[n1];
		for(int i = n1-2;i>=0;i--){
			while(!ms.isEmpty()&&ms.peek()<nums1[i]) ms.pop();
				nge[i] = (ms.isEmpty())?-1:ms.peek();
				ms.push(nums1[i]);
	        }
		return nums1;
	}
	public static void main(String[] args) {
		MonotonicStack ms = new MonotonicStack();
	}
}
