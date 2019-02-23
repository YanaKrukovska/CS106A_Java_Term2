package ua.edu.ukma.ykrukovska.unit6;

public abstract class Quadrilateral extends Figure {

    protected double side1;
    protected  double side2;
    protected  double side3;
    protected  double side4;
    protected  double angle1;
    protected  double angle2;
    protected  double angle3;
    protected  double angle4;

    public Quadrilateral(String colour, double side1, double side2, double side3, double side4, double angle1, double angle2, double angle3, double angle4) {
        super(colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.angle1 = angle1;
        this.angle2 = angle2;
        this.angle3 = angle3;
        this.angle4 = angle4;
    }



    public abstract double calculatePerimeter();


    public abstract double calculateSquare();

    @Override
    public String getData() {
        return super.getData() + ". Side 1 = " + side1 + ". Side 2 = " + side2 + ". Side 3 = " + side3 + ". Side 4 = " + side4;
    }

}
