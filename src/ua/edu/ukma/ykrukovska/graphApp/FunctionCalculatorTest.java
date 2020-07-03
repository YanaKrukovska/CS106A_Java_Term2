package ua.edu.ukma.ykrukovska.graphApp;

import org.junit.Assert;
import org.junit.Test;

public class FunctionCalculatorTest {

    @Test
    public void calculate() {

        Assert.assertEquals(2., FunctionCalculator.calculate(0., 1.), 0.1);
        Assert.assertEquals(1.6, FunctionCalculator.calculate(-1., 1.), 0.1);
        Assert.assertEquals(1.6, FunctionCalculator.calculate(1., 1.), 0.1);
    }

}