package ua.edu.ukma.ykrukovska.unit5.homework;

public class ParallelepipedTester {


    public static void main(String[] args) {

        Parallelepiped parallelepiped = new Parallelepiped(10, 10, 2, 30, 30);
        Parallelepiped perfectPar = ParallelepipedFactory.createPerfectPar(90, 60, 90);
        Parallelepiped cube = ParallelepipedFactory.createCube(50);
        System.out.println(parallelepiped);
        System.out.println(cube);
        System.out.println(perfectPar);
        System.out.println();

        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(cube));
        System.out.println();
        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(parallelepiped));
        System.out.println();
        System.out.printf("Square = %.2f", ParallelepipedUtils.calculateSquare(perfectPar));

        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(cube));
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(parallelepiped));
        System.out.println();
        System.out.printf("h = %.2f", ParallelepipedUtils.calculateHeight(perfectPar));

        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(cube));
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(parallelepiped));
        System.out.println();
        System.out.printf("v = %.2f", ParallelepipedUtils.calculateVolume(parallelepiped));

        System.out.println();
        System.out.println(ParallelepipedUtils.isCube(cube));
        System.out.println(ParallelepipedUtils.isCube(parallelepiped));
        System.out.println();
        System.out.println(ParallelepipedUtils.isPerfect(cube));
        System.out.println(ParallelepipedUtils.isPerfect(parallelepiped));

    }


}
