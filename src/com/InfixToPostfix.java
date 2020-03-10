package com;

import java.util.Stack;

public class InfixToPostfix {

    Stack<Character> stack;

    private final String DELIMITER =",";

    InfixToPostfix(){
        stack= new Stack<>();
       // postfix=new String();
    }
    public String convert(String infix){
        String postfix="";
        int length = infix.length();

        for(int currIndex = 0; currIndex< length; currIndex++){


            char currChar=infix.charAt(currIndex);

            // checks for digit
            if (Character.isLetterOrDigit(currChar)||(currChar=='.')) {
                String digit = ""+currChar;

                while ((currIndex+1)<length &&
                        (Character.isLetterOrDigit(infix.charAt(currIndex+1))
                        || (infix.charAt(currIndex+1) == '.'))) {

                    currIndex++;
                    currChar=infix.charAt(currIndex);
                    digit += currChar;
                }

                if (!digit.isEmpty()) {
                    postfix += digit + DELIMITER;
                }
            }

            //checks if open bracket then adds to stack
            else if (isOpenBracket(currChar)) {
                stack.push(currChar);
                if(isSign(infix.charAt(currIndex+1))) {
                    currIndex++;
                    postfix += infix.charAt(currIndex);
                }
            }
            //checks if closed bracket
            else if(isCloseBracket(currChar)){

                    while (!stack.isEmpty() && !isOpenBracket(stack.peek()))
                        postfix+=stack.pop()+ DELIMITER;
                    stack.pop();
            }

            //operator
            else{
                while(!stack.isEmpty() && operatorPrecedence(currChar)<= operatorPrecedence(stack.peek())){
                    postfix += stack.pop();
                    if(currIndex!=0)
                        postfix += DELIMITER;
                }
                stack.push(currChar);
                if(isSign(infix.charAt(currIndex+1))) {
                    currIndex++;
                    postfix += infix.charAt(currIndex);
                }
            }
        }

        while (!stack.isEmpty())
            postfix += stack.pop()+ DELIMITER;

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

}
