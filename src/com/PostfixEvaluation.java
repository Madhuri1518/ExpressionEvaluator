package com;

import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixEvaluation
{
    public static final String DELIMITER = ",";
    Stack<Double> stack;
    int top=-1;
    PostfixEvaluation(){
        stack=new Stack<>();

    }
    public Double evaluate(String postfix)
    {
        Double op1,op2;
        String expression[]=postfix.split(DELIMITER);
        if(expression.length==1){
            if(isDigit(expression[0])){
                return Double.parseDouble(expression[0]);
            }
        }
        else {
            for (String op : expression) {
                if (isDigit(op))
                    stack.push(Double.parseDouble(op));
                else {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    char fd = op.charAt(0);
                    switch (fd) {
                        case '+':
                            stack.push(op1 + op2);
                            break;
                        case '-':
                            stack.push(op1 - op2);
                            break;
                        case '*':
                            stack.push(op1 * op2);
                            break;
                        case '/':
                            if(Double.compare(op2,0)==0)
                                return null;
                            stack.push(op1 / op2);
                            break;
                    }
                }
            }
        }
        //String res=stack.pop()+"";
        return stack.pop();
    }

    boolean isDigit(String cc)
    {
        char pp;
        String regExp="^[\\+-]?\\d*\\.?\\d+$";
        if(Pattern.matches(regExp,cc))
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        PostfixEvaluation postfixEvaluation=new PostfixEvaluation();
        System.out.println(postfixEvaluation.evaluate("-34.9034,23.232,+"));
    }
}

