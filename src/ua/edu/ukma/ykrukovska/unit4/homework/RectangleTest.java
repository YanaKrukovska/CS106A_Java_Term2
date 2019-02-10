package ua.edu.ukma.ykrukovska.unit4.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void calculateShift1() {
        Rectangle rect = new Rectangle(0, 0, 5, 10);
        rect.rectShift(2, 0);
        assertEquals(2, rect.getX1());
        assertEquals(7, rect.getX2());
        assertEquals(0, rect.getY1());
        assertEquals(10, rect.getY2());

    }

    @Test
    public void pointNoBelong() {
        Rectangle rect = new Rectangle(0, 0, 5, 10);
        assertFalse(rect.isPointBelong(6, 11));

    }

    @Test
    public void pointBelongs() {

        Rectangle rect = new Rectangle(0, 0, 5, 10);
        assertTrue(rect.isPointBelong(2, 3));

    }

    @Test
    public void pointBelongsIfPointIsCorner() {

        Rectangle rect = new Rectangle(0, 0, 5, 10);
        assertTrue(rect.isPointBelong(5, 10));

    }

    @Test
    public void combinedRects1() {

        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(6, 4, 10, 14);
        Rectangle r3 = r1.combineRectangles(r2);
        assertEquals(0, r3.getX1());
        assertEquals(10, r3.getX2());
        assertEquals(0, r3.getY1());
        assertEquals(14, r3.getY2());
    }

    @Test
    public void combinedRects2() {
        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(1, 1, 2, 3);
        Rectangle r3 = r1.combineRectangles(r2);
        assertEquals(0, r3.getX1());
        assertEquals(5, r3.getX2());
        assertEquals(0, r3.getY1());
        assertEquals(10, r3.getY2());
    }

    @Test
    public void intersectionNo() {
        Rectangle r1 = new Rectangle(0, 0, 1, 2);
        Rectangle r2 = new Rectangle(4, 4, 5, 6);
        assertNull(r1.findIntersection(r2));

    }

    @Test
    public void intersectionInside() {
        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(1, 1, 2, 3);
        Rectangle r3 = r1.findIntersection(r2);
        assertEquals(1, r3.getX1());
        assertEquals(1, r3.getY1());
        assertEquals(2, r3.getX2());
        assertEquals(3, r3.getY2());

    }

    @Test
    public void intersectionPartly() {
        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(3, 6, 9, 11);
        Rectangle r3 = r1.findIntersection(r2);
        assertEquals(3, r3.getX1());
        assertEquals(6, r3.getY1());
        assertEquals(5, r3.getX2());
        assertEquals(10, r3.getY2());

    }

    @Test
    public void intersectionPartly1() {
        Rectangle r1 = new Rectangle(2, 0, 4, 2);
        Rectangle r2 = new Rectangle(1, 1, 3, 3);
        Rectangle r3 = r1.findIntersection(r2);
        assertEquals(2, r3.getX1());
        assertEquals(1, r3.getY1());
        assertEquals(3, r3.getX2());
        assertEquals(2, r3.getY2());

    }

    @Test
    public void intersectionPartly1Reverse() {
        Rectangle r2 = new Rectangle(2, 0, 4, 2);
        Rectangle r1 = new Rectangle(1, 1, 3, 3);
        Rectangle r3 = r1.findIntersection(r2);
        assertEquals(2, r3.getX1());
        assertEquals(1, r3.getY1());
        assertEquals(3, r3.getX2());
        assertEquals(2, r3.getY2());

    }

    @Test
    public void intersectionNeighbours() {
        Rectangle r2 = new Rectangle(0, 0, 1, 1);
        Rectangle r1 = new Rectangle(1, 1, 2, 2);
        assertNull(r1.findIntersection(r2));

    }
}