package ua.edu.ukma.ykrukovska.unit6;

public class FigureTester {


    public static void main(String[] args) {

        Circle circle = new Circle("Black", 2.);
        Triangle triangle = new Triangle("Red", 3., 2.4, 5, 60);
        Rectangle rectangle = new Rectangle("Purple", 5, 2);
        Square square = new Square("Blue", 5);


        Figure[] figures = new Figure[4];
        figures[0] = circle;
        figures[1] = triangle;
        figures[2] = rectangle;
        figures[3] = square;


        for (int i = 0; i < figures.length; i++) {
            System.out.println(" ");
            System.out.println(figures[i].getData());
            System.out.println("Perimeter = " + figures[i].calculatePerimeter());
            System.out.println("Square = " + figures[i].calculateSquare());
        }


    }

}
