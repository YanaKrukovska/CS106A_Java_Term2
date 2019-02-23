package ua.edu.ukma.ykrukovska.unit6;

public class Circle extends Figure {

    public double radius;

    public Circle(String colour, double radius) {
        super(colour);
        this.radius = radius;
    }


    @Override
    public double calculatePerimeter() {

        return 2 * Math.PI * radius;

    }

    @Override
    public double calculateSquare() {

        return Math.PI * Math.pow(radius, 2);
    }


    @Override
    public String getData() {
        return super.getData() + ". Radius = " + radius;
    }
}
