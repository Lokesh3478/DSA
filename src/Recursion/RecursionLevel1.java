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
	
	//Pattern Printing
	// *****
	// ****
	// ***
	// **
	// *
	//from 0 to n
	public static void patternPrint(int r,int c,int n) {
		if(r>=n) {
			return;
		}
		if(c>r) {
			System.out.println();
			patternPrint(r+1,0,n);
			return;
			 
		}
		System.out.print("*");
		patternPrint(r,c+1,n);
		
	}
	// form n to o
	public static void patternPrintNto0(int r,int c) {
		if(r==0) {
			return;
		}
		if(c>=r) {
			System.out.println();
			patternPrintNto0(r-1,0);
			return;
		}
		System.out.print("*");
		patternPrintNto0(r,c+1);
		
	}
	
	//SquareRootBinarySearch
	public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return (int) helper(0, x / 2 + 1, x);
    }
	
    public long helper(int start, int end, long x) {
        if (start > end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        long square = (long) mid * mid;
        if (square == x) {
            return mid;
        } else if (square > x) {
            return helper(start, mid - 1, x);
        } else {
            return helper(mid + 1, end, x);
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
		patternPrint(0,0,4);
		patternPrintNto0(4, 0);
		System.out.println("L");
	}
}
