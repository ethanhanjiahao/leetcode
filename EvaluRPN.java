package leetcode;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author HJH
 *
 */
public class EvaluRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(strings));
	}
	
	 public static int evalRPN(String[] tokens) {
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<tokens.length;i++){
	        	try {
	        		int num = Integer.parseInt(tokens[i]);
		        	stack.push(num);
				} catch (Exception e) {
					// TODO: handle exception
					int b = stack.pop();
					int a = stack.pop();
					stack.push(get(a, b, tokens[i]));
				}	        
	        }
	       return  stack.pop();
	 }
	 
	 public static int get(int a,int b,String operation){
		 switch (operation) {
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a*b;
			case "/":
				return a/b;
			default:
				return 0;
		}
	 }

}
