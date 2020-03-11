package com;

public class ExpressionEvaluator {
    ExpressionEvaluator(){
    }
    public Double evaluate(String input) {

        ValidateExpression validator = new ValidateExpression();
        if (validator.isValid(input)) {
            InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter(input);
            String postfixExp = infixToPostfixConverter.convert();
            PostfixEvaluation postfixEvaluation = new PostfixEvaluation(postfixExp);
            Double result = postfixEvaluation.evaluate();
            //System.out.println(result);
            if(result!=null)
                return result;
        }
        return null;

    }
}
