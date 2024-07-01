package math.bitmanipulate;

class NumberConversion{
	public String decimalToBase(int num,int base) {
		StringBuilder res=new StringBuilder();
		while(num>0) {
			int rem = num%base;
			if(rem>9) {
				res.insert(0,(char)(rem+55));
			}
			else {
				res.insert(0,rem);
			}
			num/=base;
		}
		return res.toString();
	}
	public int BasetoDecimal(String num,int base) {
		char arr[] = num.toCharArray();
		int res = 0,pow = 0;
		for(int i=num.length()-1;i>=0;i--) {
			int digit = 0;
			if(arr[i]>='A') {
				digit = arr[i]-55;
			}
			else {
				digit = arr[i]-'0';
			}
			res += digit*(int)(Math.pow(base, pow++));
		}
		return res;
	}
}

public class BitManipulation {
	public static void main(String[] args) {
		NumberConversion nc = new NumberConversion();
		int num = 32932021,base = 16; 
		String str = nc.decimalToBase(num,base);
		int res = Integer.parseInt(str,base);
		int testRes = nc.BasetoDecimal(str, base);
		System.out.println(str+" "+res+" "+testRes);
	}
}
