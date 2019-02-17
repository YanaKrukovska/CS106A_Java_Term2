package ua.edu.ukma.ykrukovska.unit5.homework;

public class ParallelepipedFactory {

    public static Parallelepiped createCube(int side) {
        return new Parallelepiped(side);
    }

    public static Parallelepiped createPerfectPar(int base1Length, int base2Length, int height) {
        return new Parallelepiped(base1Length, base2Length, height);
    }

}
