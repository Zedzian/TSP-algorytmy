package Visualize;

import Data.Vertex;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Visualize extends JFrame {
    private List<Vertex> route;
    private ArrayList<Color> colorArray;
    private DrawCanvas canvas;
    private int scaleFactorX=1;
    private int scaleFactorY=1;
    private int sizeX = 1050;
    private int sizeY = 550;
    private int divFactorX = sizeX;
    private int divFactorY = sizeY;

    public Visualize(List<Vertex> route) {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(sizeX, sizeY));
        this.route = route;
        this.colorArray = new ArrayList<Color>();

        int maxX=0;
        int maxY =0;
        for(Vertex v: this.route){
            if(maxX<v.getX())
                maxX = (int)v.getX();
            if(maxY<v.getY()){
                maxY=(int)v.getY();
            }
        }
        if(maxX>sizeX){
            scaleFactorX = (maxX)/(divFactorX)*2;
        }
        if(maxY>sizeY){
            scaleFactorY = (maxY)/(divFactorY)*2;
        }

        Container cp = getContentPane();
        cp.add(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("TSP Tour Visualized");
        this.setVisible(true);
    }

    private class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.blue);
            for(Vertex v: route){
                g.setColor(Color.MAGENTA);
                g.fillOval((int)v.getX()/scaleFactorX,(int)v.getY()/scaleFactorY,10,10);
            }
            for(int i=0;i<route.size()-1;i++){
                g.setColor(Color.black);
                g.drawLine((int)route.get(i).getX()/scaleFactorX, (int)route.get(i).getY()/scaleFactorY, (int)route.get(i+1).getX()/scaleFactorX, (int)route.get(i+1).getY()/scaleFactorY);
            }
        }
    }
}