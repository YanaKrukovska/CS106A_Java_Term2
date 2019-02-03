package ua.edu.ukma.ykrukovska.unit3.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;
import static ua.edu.ukma.ykrukovska.unit3.practice.CachedFactorialCalculator.*;

public class CachedFactorialCalculatorTest {


    @Test
    public void calculateFactorial0() {

        Assert.assertEquals(BigInteger.valueOf(1), calculateFactorial(0));
    }

    @Test
    public void calculateFactorial1() {

        Assert.assertEquals(BigInteger.valueOf(1), calculateFactorial(1));
    }

    @Test
    public void calculateFactorial2() {

        Assert.assertEquals(BigInteger.valueOf(2), calculateFactorial(2));
    }

    @Test
    public void calculateFactorial10() {

        Assert.assertEquals(BigInteger.valueOf(3628800), calculateFactorial(10));
    }

    @Test
    public void calculateFactorial20() {

        Assert.assertEquals(BigInteger.valueOf(2_432_902_008_176_640_000L), calculateFactorial(20));
    }


    @Test(expected = IllegalArgumentException.class)
    public void calculateFactorialNegative() {
        calculateFactorial(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateFactorialOverLimit() {
        calculateFactorial(21);
    }

}