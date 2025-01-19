package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void addTest(){
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 30;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void substractTest(){
        int actualResult = Calculator.substract(10, 20);
        int expectedResult = -10;

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void multiplyTest(){
        int actualResult = Calculator.multiply(10, 20);
        int expectedResult = 200;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideTest(){
        double actualResult = Calculator.divide(10, 5);
        double expectedResult = 2;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void moduloTest(){
        int actualResult = Calculator.modulo(10, 2);
        int expectedResult = 0;

        Assert.assertEquals(actualResult, expectedResult);
    }
}
