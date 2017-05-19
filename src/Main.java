import Logic.Heuristics.Second.SecondHeuristics;
import Util.FileReader;
import Data.Vertex;
import Util.UtilClass;
import Visualize.Visualize;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class Main {
    //4.35841e+02 5.87522e+02 0
    final static double x = 435.841;
    final static double y = 587.522;
    static List<Vertex> route = new ArrayList<>();
    static List<Vertex> solution;

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        fileReader.registerData(route);
        fileReader.readFile("test.txt");

        //FirstHeuristics firstHeuristics = new FirstHeuristics(route, x, y);
        //route = firstHeuristics.generateRoute();

        SecondHeuristics secondHeuristics = new SecondHeuristics(route, x, y);
        route = secondHeuristics.generateRoute();

        System.out.println("Wynik:" + UtilClass.tourCost(route));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Visualize(route);
            }
        });
    }
}