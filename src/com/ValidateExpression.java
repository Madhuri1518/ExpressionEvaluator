package com;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateExpression {
    Stack<Character> bracketStack;
    HashMap<Character,Character> bracketHashMap;


    public ValidateExpression(){
        bracketStack=new Stack<Character>();
        bracketHashMap =new HashMap<Character,Character>();
        bracketHashMap.put('(',')');
        bracketHashMap.put('[',']');
        bracketHashMap.put('{','}');
    }
    public boolean isValid(String s)
    {
        if(!s.contains("p")) {
            s=s.replace('.','p');
            //replace '.' with 'p'
            // regex using . is not handled properly
            Pattern pattern = Pattern.compile("^([({\\[]*[+-]?\\d*p?\\d+[)}\\]]*)" +
                    "([+-/*][({\\[]*[+-]?\\d*p?\\d+[)}\\]]*)*$");

            //System.out.println(pattern+" \n"+pattern.matcher(s)+"\n"+s+pattern.matcher(s).matches());
            Matcher matcher1 = pattern.matcher(s);
            if (matcher1.matches())
                return isBracketsAligned(s);
        }
        return false;
    }

    private boolean isBracketsAligned(String s) {

        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);

            if(isOpenBracket(c))
                bracketStack.push(c);

            else if(isCloseBracket(c)){

                if(!isLastClosedBracket(c))
                    return false;
                bracketStack.pop();
            }
        }
        if(bracketStack.isEmpty())
            return true;
        return false;
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

    private boolean isLastClosedBracket(char c){
        if(bracketStack.isEmpty())
            return false;
        char lastOpenBracket=bracketStack.peek();
        if(bracketHashMap.get(lastOpenBracket)==c)
            return true;
        return false;
    }

    public static void main(String args[]){
        String infix1="{[({9+0pp9}-0p9)*-10]-2}";
        String infix2="1p20p0+1";

        String infix3="{[({9+0.9}-0.9)*-10]-2}";
        String infix4="(2304.3432)+342.324";
        String infix="(342.234)+(9234.2340-24.23)";
        ValidateExpression regEx=new ValidateExpression();
        if(regEx.isValid(infix)) {
            System.out.println("validd");
        }
        else
            System.out.println("innnvallid");
    }

}