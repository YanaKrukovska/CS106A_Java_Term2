package ua.edu.ukma.ykrukovska.unit6;

public class Triangle extends Figure {

    private double side1;
    private double side2;
    private double side3;
    private double angle1b2;

    public Triangle(String colour, double side1, double side2, double side3, double angle1) {
        super(colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.angle1b2 = angle1;

    }


    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateSquare() {

        return 0.5 * side1 * side2 * Math.toRadians(angle1b2);
    }


    @Override
    public String getData(){
        return super.getData() + ". Side 1 = " + side1 + ". Side 2 = " + side2 + "  Side 3 = " + side3 +
                ". Angle between side 1 and side 2 = " + angle1b2;
    }
}
