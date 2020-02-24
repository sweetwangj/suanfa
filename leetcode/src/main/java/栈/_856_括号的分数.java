package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
    public static void main(String[] args) {

    }

    public int scoreOfParentheses(String S) {
        int sum=0;
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i <S.length() ; i++) {
            char c = S.charAt(i);
            if(c=='(')
            {
                stack.push(c);
            }else
            {

            }
        }
       return sum;
    }
}
