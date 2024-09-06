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
                    &&precedence.containsKey(stk.peek())
                    &&precedence.get(stk.peek())>precedence.get(ch)
                    ||(precedence.get(stk.peek())==precedence.get(ch)&&ch!='^')
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
    
    String reverse(char str[], int start, int end)
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

	// Function to convert infix to postfix expression
	String modifiedInfixToPostfix(String infix)
	{
		int l = infix.length();
		Stack<Character> stk = new Stack<>();
		String output = "";
		System.out.println(infix);
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
		l = prefix.length();
		prefix = reverse(prefix.toCharArray(), 0, l - 1);

		return prefix;
	}
	public static void main(String[] args)
	{
		String s = "(a+b)-(c*d/e)^f^g";
		ExpressionConvert ec = new ExpressionConvert();
		// Function call
		System.out.print(ec.infixToPrefix(s));//-+ab^/*cde^fg
	}
}
