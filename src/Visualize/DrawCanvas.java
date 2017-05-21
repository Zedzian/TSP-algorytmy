package Visualize;

import Data.Vertex;
import Util.UtilClass;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */
public class DrawCanvas extends JPanel {


    private int sizeX = 1200;
    private int sizeY = 923;
    private int divFactorX = sizeX;
    private int divFactorY = sizeY;
    private int scaleFactorX = 4;
    private int scaleFactorY = 4;
    private int rateX, rateY;// = ( Scaled MAX - Scaled MIN ) / ( Input MAX - Input MIN )
    private int offsetX, offsetY;// = Scaled MIN - ( Input MIN * Rate )
    public List<Vertex> route;
    int maxX = 0, minX;
    int maxY = 0, minY;
    int scaledMaxX = 1200, scaledMaxY = 923;
    int scaledMinX = 400, scaledMinY = 13;


    public DrawCanvas(List<Vertex> route) {
        super();
        this.route = route;
        setPreferredSize(new Dimension(1200, 923));
        maxX = 0;
        minX = Integer.MAX_VALUE;
        maxY = 0;
        minY = Integer.MAX_VALUE;
        for (Vertex v : this.route) {
            if (maxX < v.getX())
                maxX = (int) v.getX();
            if (maxY < v.getY()) {
                maxY = (int) v.getY();
            }
            if (minX > v.getX())
                minX = (int) v.getX();
            if (minY > v.getY()) {
                minY = (int) v.getY();
            }
        }
        System.out.println(maxX + " " + minX + " " + maxY + " " + minY);
    }

    @Override
    public void paintComponent(Graphics g) {

        rateX = (scaledMaxX - scaledMinX) / (maxX - 49);
        rateY = (scaledMaxY - scaledMinY) / (maxY - 14);
        offsetX = scaledMinX - 49 * rateX;
        offsetY = scaledMinY - 14 * rateY;
        //System.out.println(rateX+" "+rateY+" "+offsetX+" "+offsetY);
        super.paintComponent(g);
        BufferedImage img = null;
        //System.out.println("koszt w draw canvas" + maxX + " " + maxY);
        try {
            img = ImageIO.read(new File("C:/Users/m.zedzian/IdeaProjects/TSP-algorytmy/src/Data/Images/mapa.jpg"));
        } catch (IOException e) {
        }
        g.drawImage(img, 0, 0, null);
        //if (UtilClass.tourCost(route) < 24000) {
        int out_min_x =280;
        int out_max_x =1100;
        int out_min_y =107;
        int out_max_y = 903;
        for (Vertex v : route) {
            System.out.println(v.toString() + " " + (int) map(v.getY(), minX, maxX, out_min_x, out_max_x) + " " + (int) map(v.getX(), minY, maxY, 117, 913));
            if (route.indexOf(v) == 0) {
                g.setColor(Color.cyan);
                g.fillOval((int) map(v.getY(), minX, maxX, out_min_x, out_max_x), (int) map(v.getX(), minY, maxY, out_min_y, out_max_y), 23, 23);
            } else {
                g.setColor(Color.MAGENTA);
                g.fillOval((int) map(v.getY(), minX, maxX, out_min_x, out_max_x), (int) map(v.getX(), minY, maxY, out_min_y, out_max_y), 10, 10);
            }
            //System.out.println(((v.getX() - 8) / rateX) + " " + offsetX);
        }
        for (int i = 0; i < route.size() - 1; i++) {
            g.setColor(Color.black);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.drawLine((int) map(route.get(i).getY(), minX, maxX, out_min_x, out_max_x), (int) map(route.get(i).getX(), minY, maxY, out_min_y, out_max_y), (int) map(route.get(i + 1).getY(), minX, maxX, out_min_x, out_max_x), (int) map(route.get(i + 1).getX(), minY, maxY, out_min_y, out_max_y));


        }
    }

    //}
    public double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

}
