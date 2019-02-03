package ua.edu.ukma.ykrukovska.unit3.practice;

import java.math.BigInteger;

public class SimpleFactorialCalculator {

    public static BigInteger calculateFactorial(int param) {


        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= param; i++) {
           res = res.multiply(BigInteger.valueOf(i)) ;
        }
        return res;
    }

}
