package stack;

import java.util.Stack;

/**
 * @author Daffupman
 * @date 2018/11/15 15:21
 */
public class _04_EvaluateReversePolishNotation {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public static void main(String[] args){
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        //存放操作数
        Stack<Integer> stack = new Stack<>();
        //记录结果
        Integer total = 0;

        for (String token : tokens) {
            //记录一个操作符产生的结果
            Integer result = 0;
            //存放出栈的数
            Integer temp = 0;

            if(token.equals("+") || token.equals("-") || token.equals("*")|| token.equals("/")){
                //获取出栈的数
                temp = Integer.valueOf(stack.pop());
                //相应操作
                switch (token) {
                    case "+":
                        result = Integer.valueOf(stack.pop()) + temp;
                        break;
                    case "-":
                        result = Integer.valueOf(stack.pop()) - temp;
                        break;
                    case "*":
                        result = Integer.valueOf(stack.pop()) * temp;
                        break;
                    case "/":
                        result = Integer.valueOf(stack.pop()) / temp;
                        break;
                }
                //结果放入stack
                stack.push(result);
            } else {
                //把数放入stack中
                stack.push(Integer.valueOf(token));
            }
            //结果更新
            total = result;
        }
        return total;
    }

}
