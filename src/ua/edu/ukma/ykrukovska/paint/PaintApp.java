package ua.edu.ukma.ykrukovska.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
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
    //  private MyPanel drawingSpacePanel = new MyPanel();
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
    private Main.MyFrame frame;
    private Main.MyPanel panel;
    private MyPanel drawingSpacePanel;
    private BufferedImage image;
    private boolean loading = false;
    private String fileName;
    private Graphics g;// = image.getGraphics();
    private Graphics2D g2;


    public PaintApp() {

        setTitle("Paint");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBounds(0, 0, 350, 30);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu sizeMenu = new JMenu("Size");
        menuBar.add(sizeMenu);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);


        Action loadAction = new AbstractAction("Open") {
            public void actionPerformed(ActionEvent event) {
                JFileChooser jf = new JFileChooser();
                int result = jf.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        // the frame size depends on the picture size
                        fileName = jf.getSelectedFile().getAbsolutePath();
                        File iF = new File(fileName);
                        jf.addChoosableFileFilter(new TextFileFilter(".png"));
                        jf.addChoosableFileFilter(new TextFileFilter(".jpg"));
                        image = ImageIO.read(iF);
                        loading = true;
                        setSize(image.getWidth() + 40, image.getWidth() + 80);
                        drawingSpacePanel.setSize(image.getWidth(), image.getWidth());
                        drawingSpacePanel.repaint();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "This file doesn't exist");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "The exception of input/output");
                    } catch (Exception ignored) {
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
                    // Creating file filters
                    TextFileFilter pngFilter = new TextFileFilter(".png");
                    TextFileFilter jpgFilter = new TextFileFilter(".jpg");
                    if (fileName == null) {
                        // Adding filters
                        jf.addChoosableFileFilter(pngFilter);
                        jf.addChoosableFileFilter(jpgFilter);
                        int result = jf.showSaveDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            fileName = jf.getSelectedFile().getAbsolutePath();
                        }
                    }
                    // check which filter was choosen
                    if (jf.getFileFilter() == pngFilter) {
                        ImageIO.write(image, "png", new File(fileName + ".png"));
                    } else {
                        ImageIO.write(image, "jpeg", new File(fileName + ".jpg"));
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error of input/output");
                }
            }
        };
        JMenuItem saveMenu = new JMenuItem(saveAction);
        fileMenu.add(saveMenu);

        Action saveAsAction = new AbstractAction("Save as...") {
            public void actionPerformed(ActionEvent event) {

                JFileChooser fileToSave = new JFileChooser();
                int ret = fileToSave.showDialog(null, "Save");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileToSave.getSelectedFile();

                    try {
                        BufferedImage image = new BufferedImage(drawingSpacePanel.getWidth(),
                                drawingSpacePanel.getHeight(), BufferedImage.TYPE_INT_RGB);

                        Graphics2D g2d = image.createGraphics();
                        drawingSpacePanel.print(g2d);
                        g2d.dispose();
                        ImageIO.write(image, ".jpg", file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }}

           /*     try {
                    JFileChooser jf = new JFileChooser();
                    int result = jf.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileName = jf.getSelectedFile().getAbsolutePath();
                    }

                    BufferedImage im = new BufferedImage(drawingSpacePanel.getWidth(), drawingSpacePanel.getHeight(),
                            BufferedImage.TYPE_INT_ARGB);
                    Graphics2D graphics2D = im.createGraphics();
                    getContentPane().paint(graphics2D);

                        ImageIO.write(im, "jpeg", new File(fileName + ".jpg"));

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error of input/output");
                }*/
            }


        };
        JMenuItem saveAsMenu = new JMenuItem(saveAsAction);
        fileMenu.add(saveAsMenu);


        setSizeMenu(sizeMenu);


        Action clearAction = new AbstractAction("Clear") {
            public void actionPerformed(ActionEvent event) {
                drawingSpacePanel.repaint();
            }
        };

        JMenuItem clearMenu = new JMenuItem(clearAction);
        menuBar.add(clearMenu);

        JColorChooser colorChooser = new JColorChooser(Color.white);
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(getWidth() / 2, getHeight());
            }
        };

        textSizeSlider.setPaintTicks(true);

        setInstrumentsPanel();

        setColorChooserPanel(colorChooser);

        panel.add(instrumentsPanel);
        panel.add(colorChooserPanel);
        panel.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVisible(true);
        panel.setOpaque(true);

        drawingSpacePanel = new

                MyPanel(image);
        drawingSpacePanel.setBackground(Color.WHITE);
        drawingSpacePanel.setVisible(true);
        drawingSpacePanel.setOpaque(true);

        add(drawingSpacePanel);

        add(scrollPane);

        // JScrollPane scrollDrawingPane = new JScrollPane(drawingSpacePanel);
        //scrollDrawingPane.setVisible(true);
        setVisible(true);


        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (pressed) {
                    Graphics g = getGraphics();
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


            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Graphics g = getGraphics();
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
                        // focusing on the panel to add text
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

                g = getGraphics();
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

            }

        });


        drawingSpacePanel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                drawingSpacePanel.requestFocus();
            }

            public void keyTyped(KeyEvent e) {
                if (type == 3) {
                    Graphics g = getGraphics();
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

      /* addComponentListener(new ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                // if loading then change the size in the code of loading
                if (!loading) {
                  //  drawingSpacePanel.setSize(frame.getWidth() - 40, frame.getHeight() - 80);
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
        */

        //    add(scrollDrawingPane);


        setVisible(true);

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

    private void setColorChooserPanel(JColorChooser colorChooser) {
        colorChooserPanel.add(colorChooser);
        colorChooserPanel.setBounds(getWidth() / 2, getHeight() / 3, getWidth() / 2, getHeight() - getHeight() / 3);
    }

    private void setInstrumentsPanel() {
        instrumentsPanel.setLayout(new GridLayout(4, 3));
        pencilButton.addActionListener(event -> type = 0);
        instrumentsPanel.add(pencilButton);
        brushButton.addActionListener(event -> type = 1);
        instrumentsPanel.add(brushButton);
        eraserButton.addActionListener(event -> type = 2);
        instrumentsPanel.add(eraserButton);
        textButton.addActionListener(event -> type = 3);
        instrumentsPanel.add(textButton);
        instrumentsPanel.add(textSizeSlider);

        lineButton.addActionListener(event -> type = 4);
        instrumentsPanel.add(lineButton);
        ellipseButton.addActionListener(event -> type = 5);
        instrumentsPanel.add(ellipseButton);
        filledEllipseButton.addActionListener(event -> type = 6);
        instrumentsPanel.add(filledEllipseButton);
        rectangleButton.addActionListener(event -> type = 7);
        instrumentsPanel.add(rectangleButton);
        filledRectangleButton.addActionListener(event -> type = 8);
        instrumentsPanel.add(filledRectangleButton);


        instrumentsPanel.setBounds(getWidth() / 2, 0, getWidth() / 2, getHeight() / 3);
    }

    class TextFileFilter extends FileFilter {
        private String extension;

        public TextFileFilter(String extension) {
            this.extension = extension;
        }

        public boolean accept(java.io.File file) {
            if (file.isDirectory()) return true;
            return (file.getName().endsWith(extension));
        }

        public String getDescription() {
            return "*" + extension;
        }
    }

}
