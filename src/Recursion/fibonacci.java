package Recursion;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class fibonacci {
	public static int fib(int n,HashMap<Integer,Integer>map) {
		if(n<2) {
			return 1;
		}
		if(!map.containsKey(n)) {
			map.put(n,fib(n-1,map)+fib(n-2,map));
		}
		return map.get(n);
	}
	//Recursive relation solution
	public static int fibRelation(int n) {
		return (int)(Math.pow(((1+Math.sqrt(5)))/2, n)/Math.sqrt(5));
	}
	public static void main(String[] args) {
		int n = 10;
		java.util.LinkedHashMap<Integer,Integer>map = new LinkedHashMap<>();
		for(int i=0 ;i<=50;i++) {
			System.out.println(fibRelation(i));
		}

	}

}
