package com;

public class ExpressionEvaluator {
    ExpressionEvaluator(){
    }
    public Double evaluate(String infix) {

        ValidateExpression validator = new ValidateExpression();
        if (validator.isValid(infix)) {
            InfixToPostfix infixToPostfix = new InfixToPostfix();
            String postfix = infixToPostfix.convert(infix);
            PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
            Double result = postfixEvaluation.evaluate(postfix);
            //System.out.println(result);
            if(result!=null)
                return result;
        }
        return null;

    }

    public static void main(String args[]) {
        String infix1="{[({9+0.9}-0.9)*-100.01]-2}";
        String infix2="1*2+(3*4+(30/5-5+(4/2)*12-1)+1)";
        String infix3="(-34.9034)+23.232";
        String infix="(-34.9034)+23.232";
        ExpressionEvaluator expressionEvaluator=new ExpressionEvaluator();
        Double i=expressionEvaluator.evaluate(infix);
        System.out.println(i);

    }
}
