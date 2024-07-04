package Recursion;

public class RecursionLevel1 {
	//Print n to 1
	public static void printNTo1(int n) {
		if(n==0) {
			return;
		}
		System.out.print(n+" ");
		print1ToN(n-1);
	}
	//Print N to 1
	public static void print1ToN(int n) {
		if(n==0) {
			return;
		}
		print1ToN(n-1);
		System.out.print(n+" ");
	}
	
	//Factorial
	public static long factorial(long n) {
		if(n<=1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	//Sum of digits
	public static long sumOfDigits(long n) {
		if(n==0) return 0;
		return n%10 + sumOfDigits(n/10);
	}
	
	//Product of Digits
	public static long productOfDigits(long n) {
		//Returning at single digit itself to return 0 for 0 and last digit for n>0
		if(n%10==n) return n;
		return n%10 * productOfDigits(n/10);
	}
	
	//ReverseOfaNumberUsingString
	public static String reverseString(int n) {
		if(n==0) {
			return "";
		}
		return n%10 + reverseString(n/10);
	}
	
	//ReverseOfaNumberasInteger
	public static int reverseInt(int n,int expo) {
		if(n%10==n) {
			return n;
		}
		return (n%10*(int)Math.pow(10,expo))+reverseInt(n/10,expo-1);
	}
	
	//LeetCode 1342 https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
	
	public int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        if(num%2==0){
            return 1+numberOfSteps(num/2);
        }
        else{
            return 1+numberOfSteps(num-1);
        }
    }
	
	
	public static void main(String[] args) {
		print1ToN(10);
		printNTo1(10);
		for(int i=1;i<=10;i++) {
			System.out.println("Factorial of "+i+" is "+factorial(i));
		}
		for(int i=1;i<=1000;i++) {
			System.out.println("Sum of digits of "+i+" is "+sumOfDigits(i));
			System.out.println("Product of digits of "+i+" is "+productOfDigits(i));
			System.out.println("The reverse of number "+i+" is "+reverseString(i));
			System.out.println("The reverse of number "+i+" is "+reverseInt(i,(int)(Math.log10(i))));
		}
	}
}
