package LinearDS.stackProgram.expressions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class ExpressionConvert {
	HashMap<Character,Integer>precedence = new LinkedHashMap<>();
	public ExpressionConvert() {
		this.precedence.put('+',1);
	    this.precedence.put('-',1);
	    this.precedence.put('*',2);
	    this.precedence.put('/',2);
	    this.precedence.put('^',3);
	}
	public boolean isOperator(char ch){
        return (ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||ch=='^');
    }
    public String infixToPostfix(String exp) {
        String res = "";
        Stack<Character>stk = new Stack<>();
        int i =0;
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(!isOperator(ch)){
                res+=ch;
            }
            else{
                if(ch=='('){
                    stk.push(ch);
                }
                else if(ch==')'){
                    while(stk.peek()!='('){
                        res+=stk.pop();
                    }
                    stk.pop();
                }
                else{
                    while(!stk.isEmpty()
                    &&(precedence.containsKey(stk.peek())
                    &&precedence.get(stk.peek())>precedence.get(ch)
                    ||(precedence.get(stk.peek())==precedence.get(ch)&&ch!='^'))
                    		){
                        res+=stk.pop();
                    }
                    stk.push(ch);
                }
            }
            i++;
        }
        while(!stk.isEmpty()) res+=stk.pop();
        return res;
    }
    
    private String reverse(char str[], int start, int end)
	{
    	char temp;
		while (start < end) {
			str[start] = (str[start]=='(')?')':str[start]==')'?'(':str[start];
			str[end] = (str[end]=='(')?')':str[end]==')'?'(':str[end];
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
		return String.valueOf(str);
	}

	private String modifiedInfixToPostfix(String infix)
	{
		int l = infix.length();
		Stack<Character> stk = new Stack<>();
		String output = "";
		for (int i = 0; i < l; i++) {
			char ch = infix.charAt(i);
			if (!isOperator(ch))
				output += infix.charAt(i);
			else if (ch == '(')
				stk.add('(');
			else if ( ch == ')') {
				while (stk.peek() != '(') {
					output += stk.peek();
					stk.pop();
				}
				stk.pop();
			}
			else {
				while(!stk.isEmpty()
						&&(precedence.containsKey(stk.peek())
		                &&precedence.get(stk.peek())>precedence.get(ch)
		                ||(precedence.get(stk.peek())==precedence.get(ch)&&ch=='^'))
						) {
							output += stk.peek();
							stk.pop();
					}
				stk.add(infix.charAt(i));
			}
		}
		while (!stk.empty()) {
			output += stk.pop();
		}
		return output;
	}

	public String infixToPrefix(String infix)
	{
		int l = infix.length();
		infix = reverse(infix.toCharArray(), 0, l - 1);
		String prefix = modifiedInfixToPostfix(infix);
		System.out.println(prefix);
		l = prefix.length();
		prefix = reverse(prefix.toCharArray(), 0, l - 1);

		return prefix;
	}
	
	//PostFix to Infix
    /*PostFix expressions have operands followed by their immediate operator
     * so club each time a operator arrives, with the last inserted operands
     * */
    public String postFixToInfix(String exp) {
        int i =0;
        Stack<String>stk = new Stack<>();
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(!isOperator(ch)){
                stk.push(String.valueOf(ch));
            }
            else{
                String op1 = stk.pop();
                String op2 = stk.pop();
                String res = "("+op2+ch+op1+")";
                stk.push(res);
            }
            i++;
        }
        return stk.pop();
    }
    /*Prefix to Infix, A prefix contains a operator followed by its immediate operands 
     * from right to left , so add "{operator + operand1 + operand2}"
     * */
    public String preFixToInfix(String pre_exp) {
        Stack<String>stk = new Stack<>();
        int i = pre_exp.length()-1;
        while(i>=0){
            char ch = pre_exp.charAt(i);
            if(isOperator(ch)){
                String op1 = stk.pop();
                String op2 = stk.pop();
                stk.push("("+op1+ch+op2+")");
            }
            else{
                stk.push(String.valueOf(ch));
            }
            i--;
        }
        return stk.pop();
    }
    
    /*PostFix to PreFix
     * PostFix expressions contains operator immediately before the
     * operands, a right to left postfix would be reversed as prefix 
     * To obtain prefix from a left to right postfix, add operators to 
     * immediate operands from right to left 
     * i.e operand+operator2 + operator1
     * */
    public String postFixToPreFix(String post_exp) {
        int i =0;
        Stack<String>stk = new Stack<>();
        while(i<post_exp.length()){
            char ch = post_exp.charAt(i);
            if(!isOperator(ch)){
                stk.push(String.valueOf(ch));
            }
            else{
                String op1 = stk.pop();
                String op2 = stk.pop();
                String res = ch+op2+op1;
                stk.push(res);
            }
            i++;
        }
        return stk.pop();
    }
    /*Prefix to Postfix
     * In prefix operators are stored at end after operands , so right to left traversal 
     * with left to right operands concatenation is required
     * */
    public String preFixToPostFix(String pre_exp) {
        int i =pre_exp.length()-1;
        Stack<String>stk = new Stack<>();
        while(i>=0){
            char ch = pre_exp.charAt(i);
            if(!isOperator(ch)){
                stk.push(String.valueOf(ch));
            }
            else{
                String op1 = stk.pop();
                String op2 = stk.pop();
                String res = op1+op2+ch;
                stk.push(res);
            }
            i--;
        }
        return stk.pop();
    }
	public static void main(String[] args)
	{
		String s = "(a+b)-(c*d/e)^f^g";
		ExpressionConvert ec = new ExpressionConvert();
		String prefix = ec.infixToPrefix(s);
		String postfix = ec.infixToPostfix(s);
		System.out.println(s);
		System.out.println(" Infix to Prefix "+prefix);
		System.out.println("Infix to Postfix "+postfix);
		System.out.println(" PostFix to Infix "+ec.postFixToInfix(postfix));
		System.out.println(" PreFix to Infix "+ec.preFixToInfix(prefix));
		System.out.println("PostFix to Prefix "+ec.postFixToPreFix(postfix));
		System.out.println("PreFix to Postfix "+ec.preFixToPostFix(prefix));
	}
}
