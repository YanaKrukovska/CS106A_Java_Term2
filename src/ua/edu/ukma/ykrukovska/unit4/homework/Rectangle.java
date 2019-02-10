package ua.edu.ukma.ykrukovska.unit4.homework;

public class Rectangle {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }


    public void rectShift(int shiftX, int shiftY) {
        x1 += shiftX;
        x2 += shiftX;
        y1 += shiftY;
        y2 += shiftY;
    }


    public boolean isPointBelong(int pointX, int pointY) {

        return pointX >= x1 && pointX <= x2 && pointY >= y1 && pointY <= y2;
    }

    public Rectangle combineRectangles(Rectangle r2) {

        int x1 = getX1() <= r2.getX1() ? getX1() : r2.getX1();
        int y1 = getY1() <= r2.getY1() ? getY1() : r2.getY1();
        int x2 = getX2() <= r2.getX2() ? r2.getX2() : getX2();
        int y2 = getY2() <= r2.getY2() ? r2.getY2() : getY2();

        return new Rectangle(x1, y1, x2, y2);
    }


    public Rectangle findIntersection(Rectangle r2){
        int xmin = Math.max(getX1(), r2.getX1());
        int xmax1 = getX2();
        int xmax2 = r2.getX2();
        int xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            int ymin = Math.max(getY1(), r2.getY1());
            int ymax1 = getY2();
            int ymax2 = r2.getY2();
            int ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {
                return new Rectangle(xmin, ymin,xmax , ymax );
            }
        }
        return null;
    }


    public int getX1() {
        return x1;
    }


    public int getX2() {
        return x2;
    }


    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }


    @Override
    public String toString() {
        return "Coordinates (x1, y1, x2, y2): " + x1 + ", " + y1 + ", " + x2 + ", " + y2;
    }
}
