package leetcode;
import java.util.*;
public class Main {
    private int ans;
	public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = position[0]; int max = position[position.length-1]-min;
        while(min<max){
            int mid = min+(max-min)/2;
            System.out.println(min+" "+mid+" "+max);
            if(isPossible(position,mid,m)){
            	ans = mid;
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        return ans;
    }
    private boolean isPossible(int arr[],int diff,int m){
        int count =1;
        int lastPlaced = arr[0];
        for(int i =1;i<arr.length;i++){
            System.out.println("i"+lastPlaced+" "+arr[i]+" "+count);
            if(Math.abs(lastPlaced-arr[i])>=diff){
                lastPlaced = arr[i];
                count++;
                if(count>=m){
                    return true;
                }
            }
            System.out.println("i"+lastPlaced+" "+arr[i]+" "+count);
        }
        return false;
    }
    public static void main (String[] args) {
        Main m1 = new Main();
        System.out.println(m1.maxDistance(new int[]{5,4,3,2,1,1000000000},2));
    }
}