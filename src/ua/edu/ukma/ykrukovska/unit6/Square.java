package ua.edu.ukma.ykrukovska.unit6;

public class Square extends Quadrilateral {


    public Square(String colour, double side1) {
        super(colour, side1, side1, side1, side1 ,90, 90, 90, 90);
    }


    @Override
    public double calculatePerimeter() {
        return 4 * side1;
    }

    @Override
    public double calculateSquare() {
        return Math.pow(side1, 2);
    }
}
