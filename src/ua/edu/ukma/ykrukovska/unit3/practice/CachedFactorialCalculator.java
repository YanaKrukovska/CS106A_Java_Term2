package ua.edu.ukma.ykrukovska.unit3.practice;

import java.math.BigInteger;

public class CachedFactorialCalculator {

    private static BigInteger[] factorialCache = new BigInteger[21];
    private static int biggestCalculatedValue = -1;

    public static BigInteger calculateFactorial(int param) {

        if (param < 0 || param > 20) {
            throw new IllegalArgumentException("Param " + param + " is invalid. Allowed values are from 0 to 20");
        }

        BigInteger res = BigInteger.valueOf(1);
        if (param <= biggestCalculatedValue) {
            System.out.println("Value of " + param + " was found in used cache.");
            return factorialCache[param];
        } else {
            if (biggestCalculatedValue == -1) {
                System.out.println("Cache is empty. It has been initialized for 0.");
                factorialCache[0] = BigInteger.ONE;
                biggestCalculatedValue = 0;
            }
            res = factorialCache[biggestCalculatedValue];
                System.out.println("Biggest value is " + biggestCalculatedValue + " . Calculating and chaching for values " + (biggestCalculatedValue + 1) + " - " + param);
            for (int i = biggestCalculatedValue + 1; i <= param; i++) {
                res = res.multiply(BigInteger.valueOf(i));
                factorialCache[i] = res;
            }
            biggestCalculatedValue = param;
            return res;
        }
/*
        if (factorialCache[param] != null){
            System.out.println("Value of " + param + " was found in used cache.");
            return factorialCache[param];
        }
        if (factorialCache[param - 1] != null){
            System.out.println("Value of " + (param - 1) + " was found and was used to calculate" + param);
            return factorialCache[param - 1].multiply(BigInteger.valueOf(param));

        }

*/


    }

}
