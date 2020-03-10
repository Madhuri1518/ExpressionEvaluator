package com;

import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixEvaluation
{
    Stack<Double> stack;
    double str[]=new double[10];
    int top=-1;
    PostfixEvaluation(){
        stack=new Stack<Double>();

    }
    public String evaluate(String postfix)
    {
        double op1,op2;
        String expression[]=postfix.split(",");
        /*if(expression.length<1)
            return "Invalid expression";
        else*/ if(expression.length==1){
            if(isDigit(expression[0]))
                return expression[0]+"";
        }
        for(String op:expression) {
            //System.out.println(op+isDigit(op));
            if (isDigit(op)){
                System.out.println(op+" number");
                stack.push(Double.parseDouble(op));
            }else {
                op2 = stack.pop();
                op1 = stack.pop();
                //System.out.print(op1+" "+op+" "+op2);

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
                        stack.push(op1 / op2);
                        break;

                }
                //System.out.println("="+stack.peek());
            }
        }
        String res=stack.pop()+"";
       /* if(!stack.isEmpty())
            return "Invalid Expression";
        */return res;
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
        System.out.println(postfixEvaluation.evaluate("2,0.6,0.4,+,"));
    }
}

