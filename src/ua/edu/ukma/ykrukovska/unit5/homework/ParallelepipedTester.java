package ua.edu.ukma.ykrukovska.unit5.homework;

public class ParallelepipedTester {

    public static void main(String[] args) {

        Parallelepiped cube = ParallelepipedFactory.createCube(50);

        Parallelepiped perfectPar = ParallelepipedFactory.createPerfectPar(5, 5, 5);

        Parallelepiped parallelepiped = new Parallelepiped(5, 5.1, 5.1, 78, 78);

        Parallelepiped parallelepiped1 = new Parallelepiped(5, 5.1, 5, 92, 78);


        System.out.println(cube);
        System.out.println(perfectPar);
        System.out.println(parallelepiped);
        System.out.println();

        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(cube));
        System.out.println();
        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(perfectPar));
        System.out.println();
        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(parallelepiped));
        System.out.println();
        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(parallelepiped1));
        System.out.println();
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(cube));
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(perfectPar));
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(parallelepiped));
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(parallelepiped1));
        System.out.println();
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(cube));
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(perfectPar));
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(parallelepiped));
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(parallelepiped1));

        System.out.println();
        System.out.println(ParallelepipedUtils.isCube(cube));
        System.out.println(ParallelepipedUtils.isCube(parallelepiped));
        System.out.println();
        System.out.println(ParallelepipedUtils.isPerfect(cube));
        System.out.println(ParallelepipedUtils.isPerfect(parallelepiped));
    }
}
