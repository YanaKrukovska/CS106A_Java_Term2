package ua.edu.ukma.ykrukovska.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PaintApp extends JFrame {

    private final static int WIDTH = 1300;
    private final static int HEIGHT = 500;
    private JPanel instrumentsPanel = new JPanel();
    private JPanel colorChooserPanel = new JPanel();

    private JScrollPane drawingScrollPane;
    private MyPanel drawingSpacePanel;
    private JButton pencilButton = new JButton("Pencil");
    private JButton brushButton = new JButton("Brush");
    private JButton eraserButton = new JButton("Eraser");
    private JButton textButton = new JButton("Text");
    private JButton lineButton = new JButton("Line");
    private JButton ellipseButton = new JButton("Ellipse");
    private JButton filledEllipseButton = new JButton("Filled ellipse");
    private JButton rectangleButton = new JButton("Rectangle");
    private JButton filledRectangleButton = new JButton("Filled rectangle");
    private JSlider textSizeSlider = new JSlider(10, 25);


    private int type = 0;
    private int xStart;
    private int xf;
    private int yf;
    private int yStart;
    private int size = 10;
    private boolean pressed = false;
    //   private MyPanelTest drawingSpacePanel;
    private BufferedImage image;
    private boolean loading = false;
    private String fileName;
    private Graphics g;
    private Graphics2D g2;


    public PaintApp() {


        setTitle("Paint");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBounds(0, 0, 400, 30);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu sizeMenu = new JMenu("Size");
        menuBar.add(sizeMenu);

        setSizeMenu(sizeMenu);
        setClearMenu(menuBar);


        Action loadAction = new AbstractAction("Open") {
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {

                        fileName = fileChooser.getSelectedFile().getAbsolutePath();
                        File fileToOpen = new File(fileName);
                        image = ImageIO.read(fileToOpen);
                        loading = true;
                        drawingSpacePanel.setSize(image.getWidth(), image.getHeight());
                        drawingSpacePanel.repaint();


                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "This file doesn't exist");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File doesn't exist");
                    }
                }
            }
        };
        JMenuItem loadMenu = new JMenuItem(loadAction);
        fileMenu.add(loadMenu);


        Action saveAction = new AbstractAction("Save") {
            public void actionPerformed(ActionEvent event) {
                try {
                    JFileChooser jf = new JFileChooser();

                    if (fileName == null) {
                        int result = jf.showSaveDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            fileName = jf.getSelectedFile().getAbsolutePath();
                        }
                    }
                    ImageIO.write(image, "jpeg", new File(fileName + ".jpg"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong input");
                }
            }
        };
        JMenuItem saveMenu = new JMenuItem(saveAction);
        fileMenu.add(saveMenu);

        Action saveAsAction = new AbstractAction("Save as...") {
            public void actionPerformed(ActionEvent event) {

                try {
                    JFileChooser jf = new JFileChooser();
                    int result = jf.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileName = jf.getSelectedFile().getAbsolutePath();
                    }

                    ImageIO.write(image, "jpeg", new File(fileName + ".jpg"));

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong input");
                }
            }


        };

        JMenuItem saveAsMenu = new JMenuItem(saveAsAction);
        fileMenu.add(saveAsMenu);


        JColorChooser colorChooser = setColorChooserPanel();
        JPanel panel = setPanel();
        textSizeSlider.setPaintTicks(true);
        setInstrumentsPanel();
        JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);
        setDrawingPanel();

        drawingScrollPane = new JScrollPane(drawingSpacePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        drawingScrollPane.getViewport().setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        add(drawingScrollPane);


        add(scrollPane);

        setVisible(true);


        drawingSpacePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (pressed) {
                    Graphics g = image.getGraphics();
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(colorChooser.getColor());
                    switch (type) {
                        // pencil
                        case 0:
                            g2.drawLine(xStart, yStart, e.getX(), e.getY());
                            break;
                        // brush
                        case 1:
                            g2.setStroke(new BasicStroke(size));
                            g2.drawLine(xStart, yStart, e.getX(), e.getY());
                            break;
                        // eraser
                        case 2:
                            g2.setStroke(new BasicStroke(size));
                            g2.setColor(Color.WHITE);
                            g2.drawLine(xStart, yStart, e.getX(), e.getY());
                            break;
                    }
                    xStart = e.getX();
                    yStart = e.getY();

                }
                panel.repaint();
                menuBar.repaint();
                drawingSpacePanel.repaint();

            }
        });

        drawingSpacePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Graphics g = image.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(colorChooser.getColor());
                switch (type) {
                    // pencil
                    case 0:
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    // brush
                    case 1:
                        g2.setStroke(new BasicStroke(size));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    // eraser
                    case 2:
                        g2.setStroke(new BasicStroke(3.0f));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    // text
                    case 3:
                        drawingSpacePanel.requestFocus();
                        break;
                }
                xStart = e.getX();
                yStart = e.getY();
                pressed = true;

            }

            public void mousePressed(MouseEvent e) {
                xStart = e.getX();
                yStart = e.getY();
                xf = e.getX();
                yf = e.getY();
                pressed = true;
            }

            public void mouseReleased(MouseEvent e) {

                g = image.getGraphics();
                g2 = (Graphics2D) g;
                g2.setColor(colorChooser.getColor());

                int x1 = xf, x2 = xStart, y1 = yf, y2 = yStart;
                if (xf > xStart) {
                    x2 = xf;
                    x1 = xStart;
                }
                if (yf > yStart) {
                    y2 = yf;
                    y1 = yStart;
                }
                switch (type) {
                    // line
                    case 4:
                        g.drawLine(xf, yf, e.getX(), e.getY());
                        break;
                    // circle
                    case 5:
                        g.drawOval(x1, y1, (x2 - x1), (y2 - y1));
                        break;
                    case 6:
                        Ellipse2D.Double ellipse = new Ellipse2D.Double(x1, y1, (x2 - x1), (y2 - y1));
                        g2.fill(ellipse);
                        break;
                    case 7:
                        g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
                        break;
                    // rectangle
                    case 8:
                        Rectangle2D.Double rectangle = new Rectangle2D.Double(x1, y1, (x2 - x1), (y2 - y1));
                        g2.fill(rectangle);
                        break;
                }
                xf = 0;
                yf = 0;
                pressed = false;
                panel.repaint();
                menuBar.repaint();
                drawingSpacePanel.repaint();

            }

        });


        drawingSpacePanel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                drawingSpacePanel.requestFocus();
            }

            public void keyTyped(KeyEvent e) {
                if (type == 3) {
                    Graphics g = image.getGraphics();
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(colorChooser.getColor());
                    g2.setStroke(new BasicStroke(2.0f));
                    String str = "";
                    str += e.getKeyChar();
                    g2.setFont(new Font("Arial", Font.PLAIN, textSizeSlider.getValue()));
                    g2.drawString(str, xStart, yStart);
                    xStart += textSizeSlider.getValue() - 5;
                    drawingSpacePanel.requestFocus();
                }
            }
        });

        addComponentListener(new ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                if (!loading) {
                    drawingSpacePanel.setSize(getWidth(), getHeight());
                    BufferedImage tempImage = new BufferedImage(drawingSpacePanel.getWidth(), drawingSpacePanel.getHeight(),
                            BufferedImage.TYPE_INT_RGB);
                    Graphics2D d2 = tempImage.createGraphics();
                    d2.setColor(Color.white);
                    d2.fillRect(0, 0, drawingSpacePanel.getWidth(), drawingSpacePanel.getHeight());
                    tempImage.setData(image.getRaster());
                    image = tempImage;
                    drawingSpacePanel.repaint();
                }
                loading = false;
            }
        });

        setVisible(true);

    }

    private JPanel setPanel() {
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getWidth() / 2, getHeight());
            }
        };
        panel.add(instrumentsPanel);
        panel.add(colorChooserPanel);
        panel.setOpaque(true);
        panel.setVisible(true);
        return panel;
    }

    private JColorChooser setColorChooserPanel() {
        JColorChooser colorChooser = new JColorChooser(Color.white);

        colorChooserPanel.add(colorChooser);
        colorChooserPanel.setBounds(getWidth() / 2, getHeight() / 3, getWidth() / 2, getHeight() - getHeight() / 3);
        return colorChooser;
    }

    private void setClearMenu(JMenuBar menuBar) {
        Action clearAction = new AbstractAction("Clear") {
            public void actionPerformed(ActionEvent event) {
                Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, (drawingSpacePanel.getWidth()), (drawingSpacePanel.getHeight()));
                g.setColor(Color.WHITE);
                g2.fill(rect);
                drawingSpacePanel.repaint();
            }
        };

        JMenuItem clearMenu = new JMenuItem(clearAction);
        menuBar.add(clearMenu);
    }

    private void setDrawingPanel() {
        drawingSpacePanel = new MyPanel();
        System.out.println(drawingSpacePanel.getWidth());
        System.out.println(drawingSpacePanel.getHeight());
        drawingSpacePanel.setBackground(Color.WHITE);
        drawingSpacePanel.setOpaque(true);
        drawingSpacePanel.setVisible(true);
    }


    private void setSizeMenu(JMenu sizeMenu) {
        Action smallSizeAction = new AbstractAction("Small") {
            public void actionPerformed(ActionEvent event) {
                size = 5;
            }
        };
        JMenuItem smallSizeItem = new JMenuItem(smallSizeAction);
        sizeMenu.add(smallSizeItem);

        Action mediumSizeAction = new AbstractAction("Medium") {
            public void actionPerformed(ActionEvent event) {
                size = 15;
            }
        };
        JMenuItem mediumSizeItem = new JMenuItem(mediumSizeAction);
        sizeMenu.add(mediumSizeItem);

        Action bigSizeAction = new AbstractAction("Big") {
            public void actionPerformed(ActionEvent event) {
                size = 30;
            }
        };
        JMenuItem bigSizeItem = new JMenuItem(bigSizeAction);
        sizeMenu.add(bigSizeItem);
    }


    private void setInstrumentsPanel() {
        instrumentsPanel.setLayout(new GridLayout(4, 3));
        addActionListeners();
        instrumentsPanel.add(pencilButton);
        instrumentsPanel.add(brushButton);
        instrumentsPanel.add(eraserButton);
        instrumentsPanel.add(textButton);
        instrumentsPanel.add(textSizeSlider);
        instrumentsPanel.add(lineButton);
        instrumentsPanel.add(ellipseButton);
        instrumentsPanel.add(filledEllipseButton);
        instrumentsPanel.add(rectangleButton);
        instrumentsPanel.add(filledRectangleButton);

        instrumentsPanel.setBounds(getWidth() / 2, 0, getWidth() / 2, getHeight() / 3);
    }

    private void addActionListeners() {
        pencilButton.addActionListener(event -> type = 0);
        brushButton.addActionListener(event -> type = 1);
        eraserButton.addActionListener(event -> type = 2);
        textButton.addActionListener(event -> type = 3);
        lineButton.addActionListener(event -> type = 4);
        ellipseButton.addActionListener(event -> type = 5);
        filledEllipseButton.addActionListener(event -> type = 6);
        rectangleButton.addActionListener(event -> type = 7);
        filledRectangleButton.addActionListener(event -> type = 8);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }


    class MyPanel extends JPanel {

        MyPanel() {

        }

        public void paintComponent(Graphics g) {
            if (image == null) {
                image = new BufferedImage(drawingSpacePanel.getWidth(), drawingSpacePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D d2 = image.createGraphics();
                d2.setColor(Color.white);
                d2.fillRect(0, 0, drawingSpacePanel.getWidth(), drawingSpacePanel.getHeight());
            }
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

}
