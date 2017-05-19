import Logic.Heuristics.First.FirstHeuristics;
import Logic.Heuristics.Second.SecondHeuristics;
import Logic.Heuristics.Second.ThirdHeuristics;
import Util.FileReader;
import Data.Vertex;
import Visualize.Visualize;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class Main {
    private static double x;
    private static double y;
    static List<Vertex> route = new ArrayList<>();

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        fileReader.registerData(route);
        fileReader.readFile("test.txt");

//        FirstHeuristics firstHeuristics = new FirstHeuristics(route, x, y);
//        route = firstHeuristics.generateRoute();


//        parametry potrzebne do gui
//        S – miasto startowe (i końcowe) dla wszystkich kurierów
//        K – liczba kurierów (w wersji za 2/3 punktów K =1)
//        Pmax – maksymalna liczba przesyłek, które może rozwieść jeden kurier


        x = 435.841;                                               //TO
        y = 587.522;                                               //TRZEBA
        Vertex S = new Vertex(x, y, 0);                         //ZACIAGNAC
        int K = 1;                                                 //Z
        int Pmax = 400;                                   //GUI
//        Wybór heurystki

        FirstHeuristics firstHeuristics = new FirstHeuristics(route, S, K, Pmax);
        route = firstHeuristics.generateRoute();

//        SecondHeuristics secondHeuristics = new SecondHeuristics(route, S, K, Pmax);
//        route = secondHeuristics.generateRoute();

//        ThirdHeuristics thirdHeuristics = new ThirdHeuristics(route, S, K, Pmax);
//        route = thirdHeuristics.generateRoute();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Visualize(route);
            }
        });
    }
}