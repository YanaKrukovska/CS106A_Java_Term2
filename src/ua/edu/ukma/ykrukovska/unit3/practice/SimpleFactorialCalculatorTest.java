package ua.edu.ukma.ykrukovska.unit3.practice;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class SimpleFactorialCalculatorTest {

    @Test
    public void calculateFactorial0() {

        Assert.assertEquals(BigInteger.valueOf(1), SimpleFactorialCalculator.calculateFactorial(0));
    }

    @Test
    public void calculateFactorial1() {

        Assert.assertEquals(BigInteger.valueOf(1), SimpleFactorialCalculator.calculateFactorial(1));
    }
    @Test
    public void calculateFactorial2() {

        Assert.assertEquals(BigInteger.valueOf(2), SimpleFactorialCalculator.calculateFactorial(2));
    }

    @Test
    public void calculateFactorial10() {

        Assert.assertEquals(BigInteger.valueOf(3628800), SimpleFactorialCalculator.calculateFactorial(10));
    }

    @Test
    public void calculateFactorial20() {

        Assert.assertEquals(BigInteger.valueOf(2_432_902_008_176_640_000L), SimpleFactorialCalculator.calculateFactorial(20));
    }
}