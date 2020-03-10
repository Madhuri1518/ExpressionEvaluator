package com;

import javafx.geometry.Pos;

public class MainClass {
    public static void main(String args[]){
        String infix1="2-(2)";
        String infix2="2(4--3)";
        String infix3="";
        String infix4="1**2";
        String infix5="1*2*";
        String infix6="*1*2";
        String infix="1.20.0+1";
        RegEx regEx=new RegEx();
        if(regEx.valid(infix)){
            InfixToPostfix infixToPostfix=new InfixToPostfix();
            System.out.println("-------------"+infix);
            String postfix=infixToPostfix.convert(infix);
            System.out.println("-------------"+postfix);
            PostfixEvaluation postfixEvaluation=new PostfixEvaluation();
            String result=postfixEvaluation.evaluate(postfix);
            System.out.println("-------------"+infix+" \n"+postfix+"\n  output -> "+result);
        }
        else
        System.out.println("invalid expression");

    }
}
