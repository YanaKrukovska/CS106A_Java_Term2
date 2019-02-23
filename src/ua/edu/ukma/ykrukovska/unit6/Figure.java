package ua.edu.ukma.ykrukovska.unit6;

public abstract class Figure {

    protected String colour;

    public Figure(String colour) {
        this.colour = colour;
    }

    protected String getData(){
        return colour + " " + getClass().getSimpleName();
    }

    public abstract double calculatePerimeter();
    public abstract double calculateSquare();

}
