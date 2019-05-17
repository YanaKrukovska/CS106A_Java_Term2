package ua.edu.ukma.ykrukovska.graphApp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GraphCanvas extends JComponent {

    private double step;
    private double xMin;
    private double xMax;
    private double a;
    private static final double SCALE = 50;


    public GraphCanvas(double step, double xMin, double xMax, double a) {
        this.step = step;
        this.xMin = xMin;
        this.xMax = xMax;
        this.a = a;
    }


    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.BLACK);

        drawLines(gr);
        drawXPoints(gr);
        drawYPoints(gr);

        gr.setColor(Color.RED);

        double xShift = getWidth() / 2.;
        double yShift = getHeight() / 2.;
        double x1 = xMin;
        double y1 = FunctionCalculator.calculate(x1, a);

        double x2;
        double y2;

        do {
            x2 = x1 + step;
            y2 =  (FunctionCalculator.calculate(x2, a)) ;
            gr.draw(new Line2D.Double(xShift + x1*SCALE, yShift - y1*SCALE, xShift+ x2*SCALE, yShift - y2*SCALE));
            x1 = x2;
            y1 = y2;

        } while (x2 <= xMax);


    }

    private void drawYPoints(Graphics2D gr) {
        double yNegative = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            yNegative--;
            gr.drawString(Double.toString((yNegative)), (getWidth() / 2), getHeight() / 2 + c);

        }
        double yPositive = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            yPositive++;
            gr.drawString(Double.toString((yPositive)), (getWidth() / 2), getHeight() / 2 - c);
        }
    }

    private void drawXPoints(Graphics2D gr) {
        double xPositive = 0;
        for (int c = 0; c < getWidth(); c += 50) {
            gr.drawString(Double.toString((xPositive)), ((getWidth() / 2) + c), getHeight() / 2 + 10);
            xPositive++;
        }

        double xNegative = 0;
        for (int c = 50; c < getWidth(); c += 50) {
            xNegative--;
            gr.drawString(Double.toString((xNegative)), ((getWidth() / 2) - c), getHeight() / 2 + 10);
        }
    }


    private void drawLines(Graphics2D gr) {
        gr.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, getWidth());
        gr.drawLine(0, this.getHeight() / 2, getWidth(), this.getHeight() / 2);
    }

}
