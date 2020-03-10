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


    @Before
    public void setUp(){
        infix="{[({9+0.9}-0.9)*-10null1)-2}";
        infix1="2-(2)";
        infix2="2(4--3)";
        infix3="";
        infix4="1**2";
        infix5="1*2*";
        infix6="*1*2";
        infix7="1.2null+1";
        infix8="{[({9+0.9}-0.9)*-100.01]-2}";
        expressionEvaluator=new ExpressionEvaluator();
    }

    @Test
    public void evaluate() {
        assertEquals(null,expressionEvaluator.evaluate(infix),null);
        assertEquals(0.0,expressionEvaluator.evaluate(infix1),0.0);
        assertEquals(null,expressionEvaluator.evaluate(infix2),null);
        assertEquals(null,expressionEvaluator.evaluate(infix3),null);
        assertEquals(null,expressionEvaluator.evaluate(infix4),null);
        assertEquals(null,expressionEvaluator.evaluate(infix5),null);
        assertEquals(null,expressionEvaluator.evaluate(infix6),null);
        assertEquals(null,expressionEvaluator.evaluate(infix7),null);
        assertEquals(-902.09,expressionEvaluator.evaluate(infix8),-902.09);
    }
}