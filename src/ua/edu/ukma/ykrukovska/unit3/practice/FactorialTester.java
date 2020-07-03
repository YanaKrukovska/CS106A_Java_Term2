package ua.edu.ukma.ykrukovska.unit3.practice;

public class FactorialTester {

    public static void main(String[] args) {
        demoSimpleFactorialCalculator();
        demoCachedFactorialCalculator();
    }

    private static void demoCachedFactorialCalculator() {
        System.out.println("");
        System.out.println("Cached: ");
        System.out.println("Param = " + 8 + ". Result = " + CachedFactorialCalculator.calculateFactorial(8));
        System.out.println("Param = " + 12 + ". Result = " + CachedFactorialCalculator.calculateFactorial(12));
        System.out.println("Param = " + 5 + ". Result = " + CachedFactorialCalculator.calculateFactorial(5));
        System.out.println("Param = " + 16 + ". Result = " + CachedFactorialCalculator.calculateFactorial(16));
        System.out.println("Param = " + 9 + ". Result = " + CachedFactorialCalculator.calculateFactorial(9));
        System.out.println("Param = " + 20 + ". Result = " + CachedFactorialCalculator.calculateFactorial(20));
        System.out.println("Param = " + 17 + ". Result = " + CachedFactorialCalculator.calculateFactorial(17));

    }

    private static void demoSimpleFactorialCalculator() {
        System.out.println("Param = " + 8 + ". Result = " + SimpleFactorialCalculator.calculateFactorial(8));
        System.out.println("Param = " + 12 + ". Result = " + SimpleFactorialCalculator.calculateFactorial(12));
        System.out.println("Param = " + 5 + ". Result = " + SimpleFactorialCalculator.calculateFactorial(5));
        System.out.println("Param = " + 16 + ". Result = " + SimpleFactorialCalculator.calculateFactorial(16));
        System.out.println("Param = " + 20 + ". Result = " + SimpleFactorialCalculator.calculateFactorial(20));

    }
}
