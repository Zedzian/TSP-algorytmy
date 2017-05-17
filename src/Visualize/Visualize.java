package Visualize;

import Data.Vertex;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.swing.*;



public class Visualize extends JFrame {
    private List<Vertex> cities;
    private List<Vertex> solution;
    private HashMap<Integer,Color> colorMap = new HashMap<Integer,Color>();

    ArrayList<Color> colorArray;
    private DrawCanvas canvas;
    int scaleFactorX=1;
    int scaleFactorY=1;

    int sizeX = 1100;
    int sizeY = 700;
    int divFactorX = sizeX;
    int divFactorY = sizeY;

    public Visualize(List<Vertex> cities, List<Vertex> solution) {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(sizeX, sizeY));
        this.cities = cities;
        this.solution = solution;
        this.colorArray = new ArrayList<Color>();

        int maxX=0;
        int maxY =0;
        for(Vertex v: cities){
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

            for(Vertex v: cities){
                g.setColor(Color.MAGENTA);
                g.fillOval((int)v.getX()/scaleFactorX,(int)v.getY()/scaleFactorY,10,10);
            }

            g.setColor(Color.WHITE);
            for(int i=0;i<solution.size()-1;i++){
                g.setColor(Color.black);
                g.drawLine((int)solution.get(i).getX()/scaleFactorX, (int)solution.get(i).getY()/scaleFactorY, (int)solution.get(i+1).getX()/scaleFactorX, (int)solution.get(i+1).getY()/scaleFactorY);
            }
        }
    }


}

