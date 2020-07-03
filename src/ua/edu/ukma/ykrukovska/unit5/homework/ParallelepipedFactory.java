package ua.edu.ukma.ykrukovska.unit5.homework;

public class ParallelepipedFactory {

    public static Parallelepiped createCube(double side) {
        return new Parallelepiped(side);
    }

    public static Parallelepiped createPerfectPar(double base1Length, double base2Length, double height) {
        return new Parallelepiped(base1Length, base2Length, height);
    }

}
