package ua.edu.ukma.ykrukovska.unit5.homework;

public class Parallelepiped {

    private double a;
    private double b;
    private double c;
    private int slopeAngle;
    private int baseAngle;

    public Parallelepiped(double a, double b, double c, int slopeAngle, int baseAngle) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.slopeAngle = slopeAngle;
        this.baseAngle = baseAngle;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Length can't be less than 0");
        }
        if (slopeAngle < 0 || slopeAngle > 180 || baseAngle < 0 || baseAngle > 180) {
            throw new IllegalArgumentException("Angle can't be less than 0");
        }
    }

    public Parallelepiped(double a, double b, double c) {
        this(a, b, c, 90, 90);
    }

    public Parallelepiped(double a) {

        this(a, a, a, 90, 90);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int getSlopeAngle() {
        return slopeAngle;
    }

    public int getBaseAngle() {
        return baseAngle;
    }

    @Override
    public String toString() {
        return "Parallelepiped: length of 1st side of base " + a + ", length of 2nd side of base " +
                b + ", c = " + c + ", angle = " + slopeAngle + ", slope angle = " + baseAngle;
    }
}
