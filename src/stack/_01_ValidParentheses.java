package stack;

import java.util.Stack;

/**
 * @author Daffupman
 * @date 2018/11/15 14:39
 */
public class _01_ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * The brackets must close in the correct order,
     * "()" and "()[]" are all valid but "(]" and "([)]" are not.
     */

    public static void main(String[] args){
        String s = "()";
        System.out.println(isValid(s));
    }

    /**
     * 思路：使用stack存储数据
     */
    public static boolean isValid(String s) {
        //存放数据
        Stack<Character> stack = new Stack<>();

        //遍历字符串
        for (char ch : s.toCharArray()) {
            //如果该字符是'(','{','['，就放入stack中，否则就出栈
            if(ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        //只有栈空才字符串有效
        return stack.isEmpty();
    }
}
