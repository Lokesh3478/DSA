package Recursion.subsetandSubsequence;
import java.util.*;
public class solutionOfStringSubSetProblems {
	//17. Letter Combinations of a Phone Number
	static String keys[] = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static List<String> letterCombinations(String digits) {
        ArrayList<String>res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        res = pad(new StringBuilder(""),digits);
        return res;
    }
    public static ArrayList<String> pad(StringBuilder sb,String up){
        ArrayList<String>res = new ArrayList<>();
        if(up.isEmpty()){
            res.add(sb.toString());
            return res;
        }
        int digit = up.charAt(0)-'0';
        for(int i=0;i<keys[digit-1].length();i++){
            char ch = keys[digit-1].charAt(i);
            res.addAll(pad(sb.append(ch),up.substring(1)));
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }
    
    //Number of ways to get a target by using infinite number of 6 faced dice at each move 
    //Target Sum using given array
    public static ArrayList<ArrayList<Integer>>targetSum(int arr[],int target,ArrayList<Integer>processed){
    	ArrayList<ArrayList<Integer>>res = new ArrayList<>();
    	if(target==0) {
    		res.add(new ArrayList<Integer>(processed));
    		return res;
    	}
    	if(target<0) {
    		return res;
    	}
    	for(int i=0;i<arr.length&&i<=target;i++) {
    		processed.add(arr[i]);
    		res.addAll(targetSum(arr, target-arr[i], processed));
    		processed.remove(processed.size()-1);
    	}
    	return res;
    }
    
    
    //Custom faced dice , fixed number of times to attain a target
    public static int numRollsToTarget(int n, int k, int target) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n <= 0 || target <= 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count += numRollsToTarget(n - 1, k, target - i);
        }
        return count;
    }
	public static void main(String[] args) {
		int dice[] = new int[] {1,2,3,4,5,6};
		System.out.println(targetSum(dice, 4, new ArrayList<Integer>()));
		System.out.println(numRollsToTarget(2, 6, 7));
	}
	
}
