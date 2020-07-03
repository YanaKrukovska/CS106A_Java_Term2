package ua.edu.ukma.ykrukovska.unit4.homework;

public class RectangleTester {

    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle(5, 0, 10, 5);
        Rectangle rect2 = new Rectangle(7, 2, 8, 3);

        System.out.println("Rectangle 1: " + rect1);
        System.out.println("Rectangle 2: " + rect2);

        int shiftX = -5;
        int shiftY = -10;
        rect1.rectShift(shiftX, shiftY);
        System.out.println("Rect 1 has been shifted x: " + shiftX + ", y: " + shiftY + " New coordinates: " + rect1);
        rect1.rectShift(-shiftX, -shiftY);

        int pointX = 0;
        int pointY = 0;
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
