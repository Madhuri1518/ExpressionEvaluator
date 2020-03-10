package com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ExpressionEvaluatorTest {

    ExpressionEvaluator expressionEvaluator;
    String infix;
    String infix1;
    String infix2;
    String infix3;
    String infix4;
    String infix5;
    String infix6;
    String infix7;
    String infix8;
    String infix9;


    @Before
    public void setUp(){
        infix="{[({9+0.9}-0.9)*-100.01)-2}";
        infix1="2-(2)";
        infix2="2(4--3)";
        infix3="";
        infix4="1**2";
        infix5="1*2*";
        infix6="*1*2";
        infix7="1.20.0+1";
        infix8="{[({9+0.9}-0.9)*-100.0]-2}";
        infix9="";
        expressionEvaluator=new ExpressionEvaluator();
    }

    @Test
    public void evaluate() {
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix));
        assertEquals("0.0",expressionEvaluator.evaluate(infix1));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix2));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix3));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix4));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix5));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix6));
        assertEquals("Invalid Expression",expressionEvaluator.evaluate(infix7));
        assertEquals("-902.0",expressionEvaluator.evaluate(infix8));
    }
}