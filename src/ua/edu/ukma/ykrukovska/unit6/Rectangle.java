package ua.edu.ukma.ykrukovska.unit6;

public class Rectangle extends Quadrilateral {


    public Rectangle(String colour, double side1, double side2) {
        super(colour, side1, side2, side1, side2, 90, 90, 90, 90);
    }



    @Override
    public double calculatePerimeter() {

        return (side1 + side2) * 2;

    }


    @Override
    public double calculateSquare() {

        return side1 * side2;

    }

}
