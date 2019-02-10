package ua.edu.ukma.ykrukovska.unit4.homework;

public class RectangleTester {


    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle(0, 0, 4, 2);
        Rectangle rect2 = new Rectangle(1, 1, 6, 5);

        System.out.println("Rectangle 1: " + rect1);
        System.out.println("Rectangle 2: " + rect2);

        int shiftX = 2;
        int shiftY = 2;
        rect1.rectShift(shiftX, shiftY);
        System.out.println("Rect 1 has been shifted x: " + shiftX + ", y: " + shiftY + " New coordinates: " + rect1);
        rect1.rectShift(-shiftX, -shiftY);

        int pointX = 5;
        int pointY = 5;
        System.out.println("Point (" + pointX + ", " + pointY + ") " + (rect1.isPointBelong(pointX, pointY) ? "belongs" : "doesn't belong"));
        System.out.println("Combined rectangles: " + rect1.combineRectangles(rect2));

        Rectangle intersected = rect1.findIntersection(rect2);
        if (intersected == null) {
            System.out.println("Rectangles don't intersect");
        } else {
            System.out.println("Coordinates of intersection: " + intersected);
        }

    }
}
