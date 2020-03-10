package com;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CalculationServiceTest {


    private CalculationService calculationService;

    @Before
    public void setup(){
        calculationService = new PostfixCalculationService();
    }

    @Test
    public void testResultInt(){
        String query = "";
        Assert.assertEquals(0, calculationService.calculateInt(query));
        query="1*2+(3*4+(30/5-5+(4/2)*12-1)+1)";
        Assert.assertEquals(39,calculationService.calculateInt(query));
        query="2-(2)";
        Assert.assertEquals(0,calculationService.calculateInt(query));
        query="2(4--3)";
        Assert.assertEquals(0,calculationService.calculateInt(query));
        query="1**2";
        Assert.assertEquals(0,calculationService.calculateInt(query));
        query="1*2*";
        Assert.assertEquals(0,calculationService.calculateInt(query));
        query="*1*2";
        Assert.assertEquals(0,calculationService.calculateInt(query));

    }

    @Test
    public void testResultFloat(){
        String query = "";
        Assert.assertEquals(0f, calculationService.calculateFloat(query), 0f);
        query="(90.99--9.01)*10/0";
        Assert.assertEquals(0f, calculationService.calculateFloat(query), 0f);
        query="{[({9+0.9}-0.9)*-100.01]-2}";
        Assert.assertEquals(-902.09f, calculationService.calculateFloat(query), 0f);

    }

    @Test
    public void testResultLong(){
        String query = "";
        Assert.assertEquals(0, calculationService.calculateLong(query));
        query = "32434+23232-343432*2323";
        Assert.assertEquals(-797736870, calculationService.calculateLong(query));
    }

    @Test
    public void testResultDouble(){
        String query = "";
        Assert.assertEquals(0, calculationService.calculateDouble(query), 0);
        query = "32434.129+23232.12309-343432.2382/(343432.2382*2)";
        Assert.assertEquals(55665.75209, calculationService.calculateDouble(query),0.0);
        query = "(-34.9034)+23.232";
        Assert.assertEquals(-11.6714, calculationService.calculateDouble(query),0.00001);
        query="{[({9+0.9}-0.9)*-100)-2}";//brackets are not closed properly
        Assert.assertEquals(0.0, calculationService.calculateDouble(query),0.00001);
        query="1.2null+1";
        Assert.assertEquals(0.0, calculationService.calculateDouble(query),0.00001);

    }
}