package ua.edu.ukma.ykrukovska.graphApp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GraphCanvas extends JComponent {

    private double krok;
    private double y;
    private double x;
    private double xMin;
    private double xMax;
    private double a;
    private static final double SCALE = 50;

    public GraphCanvas(double krokValue, double xMin, double xMax, double a) {
        this.krok = 0.01;
        this.xMax = 10;
        this.xMin = -10;
        this.a = 1;
    }

    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.BLACK);

        //Draw X and Y lines
        gr.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, getWidth());
        gr.drawLine(0, this.getHeight() / 2, getWidth(), this.getHeight() / 2);


        //X points
        double kx = 0;
        for (int c = 0; c < getWidth(); c += 50) {
            gr.drawString(Double.toString((kx)), ((getWidth() / 2) + c), getHeight() / 2 + 10);
            kx++;
        }

        double kxm = 0;
        for (int c = 50; c < getWidth(); c += 50) {
            kxm--;
            gr.drawString(Double.toString((kxm)), ((getWidth() / 2) - c), getHeight() / 2 + 10);
        }

        //Y points
        double ky = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            ky++;
            gr.drawString(Double.toString((ky)), (getWidth() / 2), getHeight() / 2 + c);

        }

        double kym = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            kym--;
            gr.drawString(Double.toString((kym)), (getWidth() / 2), getHeight() / 2 - c);
        }

        gr.setColor(Color.RED);



        double xShift = getWidth() / 2.;
        double yShift = getHeight() / 2.;
        double x1 = xMin;
        double y1 = FunctionCalculator.calculate(x1, a);

        double x2;
        double y2;

        do {
            x2 = x1 + krok;
            y2 =  (FunctionCalculator.calculate(x2, a)) ;
            gr.draw(new Line2D.Double(xShift + x1*SCALE, yShift - y1*SCALE, xShift+ x2*SCALE, yShift - y2*SCALE));
            System.out.println("x1 = " + x1 + " " + y1);
            x1 = x2;
            y1 = y2;

        } while (x2 <= xMax);


    }

}
