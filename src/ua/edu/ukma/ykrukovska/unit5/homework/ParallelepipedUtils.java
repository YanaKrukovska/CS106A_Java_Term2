package ua.edu.ukma.ykrukovska.unit5.homework;

public class ParallelepipedUtils {

    private ParallelepipedUtils() {
    }

    public static double calculateSquare(Parallelepiped p) {
        return p.getA() * p.getB() * Math.sin(Math.toRadians(p.getBaseAngle()));

    }

    public static double calculateHeight(Parallelepiped p) {
        return  p.getC() * Math.sin(Math.toRadians(p.getSlopeAngle()));

    }

    public static double calculateVolume(Parallelepiped p){

        return calculateSquare(p) * calculateHeight(p);
    }

    public static boolean isPerfect(Parallelepiped p){

        return p.getBaseAngle() == 90 && p.getSlopeAngle() == 90;
    }

    public static boolean isCube(Parallelepiped p){

        return p.getA() == p.getB()&& p.getB() == p.getC() && isPerfect(p);
    }
}
