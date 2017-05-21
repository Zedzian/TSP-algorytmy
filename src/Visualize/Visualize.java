package Visualize;

import Data.Vertex;
import Logic.Heuristics.First.FirstHeuristics;
import Logic.Heuristics.Second.SecondHeuristics;
import Logic.Heuristics.Third.ThirdHeuristics;
import Util.FileReader;
import Util.UtilClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Visualize extends JFrame {
    final List<Vertex> route;
    private ArrayList<Color> colorArray;
    private DrawCanvas canvas;
    private int scaleFactorX = 1;
    private int scaleFactorY = 1;
    private int sizeX = 1200;
    private int sizeY = 923;
    private int divFactorX = sizeX;
    private int divFactorY = sizeY;

    public Visualize(List<Vertex> route) {

        System.out.println("route cost: " + UtilClass.tourCost(route));
//        FirstHeuristics firstHeuristics = new FirstHeuristics(route, new Vertex(435.841, 587.522, 0), 1, 400);
//        firstHeuristics.generateRoute();
        System.out.println("jas");
        canvas = new DrawCanvas(route);
        canvas.setPreferredSize(new Dimension(1200, 923));
        this.route = route;
        this.colorArray = new ArrayList<Color>();
        int maxX = 0;
        int maxY = 0;
        for (Vertex v : this.route) {
            if (maxX < v.getX())
                maxX = (int) v.getX();
            if (maxY < v.getY()) {
                maxY = (int) v.getY();
            }
        }
        if (maxX > sizeX) {
            scaleFactorX = (maxX) / (divFactorX) * 2;
        }
        if (maxY > sizeY) {
            scaleFactorY = (maxY) / (divFactorY) * 2;
        }
        Container cp = getContentPane();

        JComboBox<Vertex> vertices = new JComboBox<Vertex>(route.toArray(new Vertex[route.size()]));
        vertices.setBounds(7, 73, 200, 50);
        String[] heuristics = new String[3];
        heuristics[0] = "Heurystyka nr 1";
        heuristics[1] = "Heurystyka nr 2";
        heuristics[2] = "Heurystyka nr 3";
        JComboBox<String> heuristicsJComboBox = new JComboBox<String>(heuristics);
        heuristicsJComboBox.setBounds(7, 13, 200, 50);
        JTextField Pmax = new JTextField("Podaj liczbę przesyłek");
        Pmax.setBounds(7, 133, 200, 50);
        JTextField K = new JTextField("Podaj liczbę kurierów");
        K.setBounds(7, 193, 200, 50);
        JButton button = new JButton("Rozpocznij liczenie heurystki");
        button.setBounds(7, 253, 200, 50);
        JLabel result = new JLabel("Wynik: ");
        result.setBounds(7, 313, 200, 50);

        cp.add(heuristicsJComboBox);
        cp.add(vertices);
        cp.add(Pmax);
        cp.add(K);
        cp.add(button);
        cp.add(result);
        cp.add(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setTitle("TSP Tour Visualized");
        this.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Vertex> routeV;
                Vertex S;
                int intK = 1, intPmax = 310;
                if (vertices.getSelectedIndex() == (-1)) {
                    S = new Vertex(559.929, 171.432, 0);
                } else {
                    S = new Vertex(route.get(vertices.getSelectedIndex()).getX(), route.get(vertices.getSelectedIndex()).getY());
                }

                try {
                    if (Integer.parseInt(Pmax.getText()) < 400 || Integer.parseInt(Pmax.getText()) > 0) {
                        intPmax = Integer.parseInt(Pmax.getText());
                    } else {
                        intPmax = 400;
                    }
                } catch (NumberFormatException exception) {
                    intPmax = 400;
                }

                try {
                    if (Integer.parseInt(K.getText()) > 0) {
                        intK = Integer.parseInt(K.getText());
                    } else {
                        intK = 1;
                    }
                } catch (NumberFormatException exception) {
                    intK = 1;
                }

                if (heuristicsJComboBox.getSelectedIndex() == (-1) || heuristicsJComboBox.getSelectedIndex() == (0)) {
                    FirstHeuristics firstHeuristics = new FirstHeuristics(route, S, intK, intPmax);
                    routeV = firstHeuristics.generateRoute();
                } else if (heuristicsJComboBox.getSelectedIndex() == (1)) {
                    SecondHeuristics secondHeuristics = new SecondHeuristics(route, S, intK, intPmax);
                    routeV = secondHeuristics.generateRoute();
                } else {
                    System.out.println("route cost: w else buttona: " + UtilClass.tourCost(route));
                    ThirdHeuristics thirdHeuristics = new ThirdHeuristics(route, S, intK, intPmax);
                    routeV = thirdHeuristics.generateRoute();
                    System.out.println("routev cost: w else buttona: " + UtilClass.tourCost(routeV));
                }
                canvas.route = routeV;
                //System.out.println("rep" + heuristicsJComboBox.getSelectedIndex());
                result.setText("Wynik: " + String.valueOf(UtilClass.tourCost(routeV)));
                getContentPane().validate();
                getContentPane().repaint();
            }
        });
    }
}