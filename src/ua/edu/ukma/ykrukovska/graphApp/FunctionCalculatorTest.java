package ua.edu.ukma.ykrukovska.graphApp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionCalculatorTest {

    @Test
    public void calculate() {

        Assert.assertEquals(2., FunctionCalculator.calculate(0.,1.),0.1);
        Assert.assertEquals(1.6, FunctionCalculator.calculate(-1.,1.),0.1);
        Assert.assertEquals(1.6, FunctionCalculator.calculate(1.,1.),0.1);
    }

    @Test
    public void getMaxY() {

        Assert.assertEquals(2., FunctionCalculator.getMaxY(-10.,10., 1, 1),0.1);

    }

    @Test
    public void getMinY() {

        Assert.assertEquals(0.07, FunctionCalculator.getMinY(-10.,10., 1, 1),0.1);

    }
}