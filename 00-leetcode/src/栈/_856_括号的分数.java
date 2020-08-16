package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
	
	/**
	 * 思路：
	 * 	总共三种情况：
	 * 	1. () 得1分
	 * 	2. ABC 得A+B+C分
	 * 	3. (ABC) 得（A+B+C）*2
	 * 解题：
	 * 	1. 左括号入栈
	 * 	2. 右括号进行判断：
	 * 		①栈顶为左括号，此时是(),得1，将分数入栈
	 * 		②栈顶不为左括号，(ABC)，得（A+B+C)*2，将分数入栈
	 * 	3.最后出栈，计算所有分数
	 * @param S
	 * @return
	 */
    public int scoreOfParentheses(String S) {
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < S.length(); i++) {
    		char c = S.charAt(i);
			if (c == '(') { // 左括号入栈
				stack.push(0);
			} else {
				if (stack.peek() == 0) {// 左括号,此时是(),得1
					stack.pop();
					stack.push(1);
				} else {
					int score = 0;
					while (stack.peek() != 0) { // 连续出栈，分数相加 A+B+C
						score += stack.peek();
						stack.pop();
					}
					stack.pop();
					stack.push(score*2);
				}
			}
		}
    	int result = 0;
		while (!stack.isEmpty()) {
			result += stack.peek();
			stack.pop();
		}
    	return result;
    }

}
