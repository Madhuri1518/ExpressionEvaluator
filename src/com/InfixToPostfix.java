package com;

import java.util.Stack;

public class InfixToPostfix {

    Stack<Character> stack;

    private final String delimiter =",";

    InfixToPostfix(){
        stack=new Stack<Character>();
       // postfix=new String();
    }
    public String convert(String infix){
        String postfix="";
        int length = infix.length();
        l:for(int currIndex = 0; currIndex< length; currIndex++){
            char currChar=infix.charAt(currIndex);
            String digit="";

            //boolean firstPoint=true;
            
            while(Character.isLetterOrDigit(currChar)||(currChar=='.')) {
                /*if(currChar=='.') {
                    if(firstPoint)
                    firstPoint = false;
                    else
                        return "Invalid Expression";
                    if(!Character.isLetterOrDigit(infix.charAt(currIndex+1)))
                        return "Invalid Expression0";
                }*/
                digit += currChar;
                currIndex++;
                if(currIndex< length)
                    currChar=infix.charAt(currIndex);
                else {
                    postfix += digit+ delimiter;
                    break l;
                }
            }

            if(!digit.isEmpty()) {
                postfix += digit+ delimiter;
            }
            if (isOpenBracket(currChar)) {
                stack.push(currChar);
                if(isSign(infix.charAt(currIndex+1))) {
                    postfix += infix.charAt(currIndex + 1);
                    currIndex++;
                }
            }
            else if(isCloseBracket(currChar)){

                    while (!stack.isEmpty() && !isOpenBracket(stack.peek()))
                        postfix+=stack.pop()+ delimiter;
                    /*if (!stack.isEmpty() && !isOpenBracket(stack.peek()))
                        return "Invalid Expression2"; // invalid expression
                    else*/
                        stack.pop();
                }
            else{
                /*if(!isOperator(c))
                    return "Invalid Expression4";*/
                while(!stack.isEmpty() && operatorPrecedence(currChar)<= operatorPrecedence(stack.peek())){
                    /*if(isOpenBracket(stack.peek()))
                        return "Invalid Expression3";*/
                    postfix += stack.pop();
                    if(currIndex!=0)
                        postfix += delimiter;
                }
                stack.push(currChar);
                if(isSign(infix.charAt(currIndex+1))) {
                    postfix += infix.charAt(currIndex + 1);
                    currIndex++;
                }
            }
        }

        while (!stack.isEmpty()){
            /*if(stack.peek().equals("("))
                return "Invalid Expression";*/
            postfix += stack.pop()+ delimiter;
        }
        return postfix;
    }

    private boolean isOperator(char c) {
        String operator="+-*/%^";
        if(operator.contains(c+""))
            return true;
        return false;
    }

    private boolean isSign(char c) {
        String operator="+-";
        if(operator.contains(c+""))
            return true;
        return false;

    }

    private int operatorPrecedence(char peek) {
        switch (peek)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    private boolean isOpenBracket(char c) {
        String bracket="([{";
        if(bracket.contains(c+"")){
            return true;
        }
        return false;
    }

    private boolean isCloseBracket(char c) {
        String bracket=")]}";
        if(bracket.contains(c+"")){
            return true;
        }
        return false;
    }

    /*private boolean isLastClosedBracket(char c){
        if(bracketStack.isEmpty())
            return false;
        char lastOpenBracket=bracketStack.peek();
        if(bracketHashMap.get(lastOpenBracket)==c)
            return true;
        return false;
    }*/

    public static void main(String args[]){
        InfixToPostfix infixToPostfix=new InfixToPostfix();
        System.out.println(infixToPostfix.convert("2(0.6+0.4)"));

    }
}
