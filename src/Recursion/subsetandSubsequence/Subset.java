package Recursion.subsetandSubsequence;
import java.util.*;
public class Subset {
	
	public String skipCharacter(String str,StringBuilder sb,char skip) {
		if(str.length()==0) {
			return sb.toString();
		}
		if(str.charAt(0)!=skip) {
			sb.append(str.charAt(0));
		}
		return skipCharacter(str.substring(1), sb, skip);
	}
	public void skipCharacterTest() {
		System.out.println(skipCharacter("ferfnrfnsdqaa",new StringBuilder(),'f'));
		System.out.println(skipCharacter("ferfnrfnsdqaa",new StringBuilder(),'q'));
		System.out.println(skipCharacter("ferfnrfnsdqaa",new StringBuilder(),'n'));
		System.out.println(skipCharacter("ferfnrfnsdqaa",new StringBuilder(),'z'));
	}
	
	public String skipString(String str,StringBuilder sb,String skip) {
		if(str.length()<skip.length()||str.length()==0) {
			sb.append(str);
			return sb.toString();
		}
		boolean startWith = true;
		int i= 0;
		while(i<skip.length()) {
			if(str.charAt(i)!=skip.charAt(i)) {
				startWith = false;
				break;
			}
			i++;
		}
		if(startWith) {
			return skipString(str.substring(skip.length()), sb, skip);
		}
		sb.append(str.charAt(0));
		return skipString(str.substring(1), sb, skip);
	}
	public void skipStringTester() {

		List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[]{"hello world", "world", "hello "});
        testCases.add(new String[]{"banana", "na", "ba"});
        testCases.add(new String[]{"banana", "a", "bnn"});
        testCases.add(new String[]{" ", "any", " "});
        testCases.add(new String[]{"abc", " ", "abc"});
        testCases.add(new String[]{"123123123", "123", ""});
        testCases.add(new String[]{"test", "test", ""});
        for (String[] testCase : testCases) {
            String inputString = testCase[0];
            String substringToRemove = testCase[1];
            String expectedOutput = testCase[2];
            String result = skipString(inputString,new StringBuilder(),substringToRemove);
            System.out.println("Input: " + inputString + ", Substring: " + substringToRemove);
            System.out.println("Expected Output: " + expectedOutput);
            System.out.println("Actual Output: " + result);
            System.out.println(result.equals(expectedOutput) ? "Test Passed" : "Test Failed");
            System.out.println();
        }
	}
	
	public ArrayList<String>subset(String str){
		ArrayList<String>res = subset("",str);
		return res;
	}
	 private static ArrayList<String> subset(String Processed,String unProcessed ) {
	        if (unProcessed.isEmpty()) {
	            ArrayList<String>list = new ArrayList<>();
	            list.add(Processed);
	            return list;
	        } else {
	        	ArrayList<String>left = subset(Processed+unProcessed.charAt(0),unProcessed.substring(1));
	        	ArrayList<String>right = subset(Processed,unProcessed.substring(1));
	            left.addAll(right);
	            return left;
	        }
	}
	private void subsetTest() {
		Map<String, List<String>> testCases = new HashMap<>();

        testCases.put("abc", List.of("abc","ab","ac","a","bc","b","c",""));
        testCases.put("ab", List.of("ab", "a", "b", ""));
        testCases.put("a", List.of("a", ""));
        testCases.put("", List.of(""));
        testCases.put("xy", List.of("xy", "x", "y", ""));

        for (Map.Entry<String, List<String>> entry : testCases.entrySet()) {
            String input = entry.getKey();
            List<String> expectedOutput = entry.getValue();
            List<String> result = subset(input);

            System.out.println("Input: " + input);
            System.out.println("Expected Output: " + expectedOutput);
            System.out.println("Actual Output: " + result);
            System.out.println(result.equals(expectedOutput) ? "Test Passed" : "Test Failed");
            System.out.println();
        }
	}

	private List<String> iterativeSubset(String str) {
		ArrayList<String>finalSet = new ArrayList<String>();
		finalSet.add(""); //Empty subset i.e 2^0
		for(char ch : str.toCharArray()) {
			int size = finalSet.size();
			for(int i=0;i<size;i++) {
				String innerSet = finalSet.get(i)+ch;
				finalSet.add(innerSet);
				
			}
		}
		return finalSet;
	}
	
	public ArrayList<char[]>permutation(String s){
		ArrayList<char[]>list = new ArrayList<>();
		permutation(list,s,s.length(),0,new char[s.length()]);
		return list;
	}
	public void permutation(ArrayList<char[]>res,String s,int n,int ind,char arr[]){
		if(ind>=n) {
			res.add(Arrays.copyOf(arr, n));
			return;
		}
		for(int i=0;i<n;i++) {
			if(arr[i]=='\0') {
				arr[i] = s.charAt(ind);
				permutation(res,s,n,ind+1,arr);
				arr[i] = '\0';
			}
		}
	}
	
	public ArrayList<String> permutation(String s,String p) {
		if(s.isEmpty()) {
			ArrayList<String>list = new ArrayList<String>();
			list.add(p);
			return list;
		}
		ArrayList<String>list = new ArrayList<String>();
		char ch = s.charAt(0);
		for(int i=0;i<=p.length();i++) {
			String f = p.substring(0,i);
			String sec = p.substring(i,p.length());
			list.addAll(permutation(s.substring(1),f+ch+sec));
		}
		return list;
	}
	
	public static void main(String[] args) {
		Subset s1 = new Subset();
		s1.skipCharacterTest(); s1.skipStringTester();s1.subsetTest();s1.subset("ghdsdnsknkdfnknvdfknkdfnvkdf");
		ArrayList<char[]>perm = s1.permutation("abc");
		for(char[]c: perm) {
			System.out.println(Arrays.toString(c));
		}
		
	}
}
