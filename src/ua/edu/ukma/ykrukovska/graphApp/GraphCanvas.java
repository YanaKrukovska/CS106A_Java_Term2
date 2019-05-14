package ua.edu.ukma.ykrukovska.graphApp;

import javax.swing.*;
import java.awt.*;

public class GraphCanvas extends JComponent {


    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.BLACK);

        //Draw X and Y lines
        gr.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, getWidth());
        gr.drawLine(0, this.getHeight() / 2, getWidth(), this.getHeight() / 2);


        //X points
        int kx = 0;
        for (int c = 0; c < getWidth(); c += 50) {
            gr.drawString(Integer.toString((kx)), ((getWidth() / 2) + c), getHeight() / 2 + 10);
            kx++;
        }


        int kxm = 0;
        for (int c = 50; c < getWidth(); c += 50) {
            kxm--;
            gr.drawString(Integer.toString((kxm)), ((getWidth() / 2) - c), getHeight() / 2 + 10);
        }

        //Y points
        int ky = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            ky++;
            gr.drawString(Integer.toString((ky)), (getWidth() / 2), getHeight() / 2 + c);

        }

        int kym = 0;
        for (int c = 50; c < getHeight(); c += 50) {
            kym--;
            gr.drawString(Integer.toString((kym)), (getWidth() / 2), getHeight() / 2 - c);
        }

        gr.setColor(Color.BLUE);
        //computeCoordinates(aValue, fiMaxValue);
        //gr.drawPolyline(mX, mY, coordinatesNumber);
    }


}
