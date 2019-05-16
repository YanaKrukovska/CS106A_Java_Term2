package ua.edu.ukma.ykrukovska.graphApp;

public class FunctionCalculator {


    public static double calculate(double x, double a) {

        return (8 * Math.pow(a, 3)) / (Math.pow(x, 2) + 4 * Math.pow(a, 2));

    }

    public static double getMaxY(double xMin, double xMax, double a, double step){
        double result = Double.MIN_VALUE;

        double currentX = xMin;
        do {
            double currentY = calculate(currentX,a);
            if (currentY > result){
                result = currentY;
            }
            currentX+=step;

        } while (currentX <= xMax);


        return result;
    }

    public static double getMinY(double xMin, double xMax, double a, double step){
        double result = Double.MAX_VALUE;

        double currentX = xMin;
        do {
            double currentY = calculate(currentX,a);
            if (currentY < result){
                result = currentY;
            }
            currentX+=step;

        } while (currentX <= xMax);


        return result;
    }
}
