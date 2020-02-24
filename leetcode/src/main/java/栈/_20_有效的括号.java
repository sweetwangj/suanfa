package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public static boolean isValid1(String s) {

        while(s.contains("{}") || s.contains("[]") || s.contains("()")
        )
        {
            s= s.replace("{}", "");
            s=s.replace("[]","");
            s=s.replace("()","");
        }
        if(s.length()==0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 栈实现
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c=='{' || c=='[' || c=='(')
            {
                stack.push(c);
            }else
            {
                if(stack.isEmpty()) return false;
                char left = stack.pop();
                if(left=='{' && c!='}') return false;
                if(left=='[' && c!=']') return false;
                if(left=='(' && c!=')') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid1("{}()["));
    }
}
