
import Logic.GreedyPathGenerator;
import Logic.KOPT;
import Logic.TSPSolver;
import Util.FileReader;
import Data.Vertex;
import Util.UtilClass;
import Visualize.Visualize;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 14-05-2017.
 */

public class Main {

    final static double x = 607.71;
    final static double y = 673.196;
    static List<Vertex> route = new ArrayList<>();

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        fileReader.registerData(route);
        fileReader.readFile("test.txt");
        GreedyPathGenerator greedyPathGenerator = new GreedyPathGenerator(route);
        route = greedyPathGenerator.createPath(x, y);
        System.out.println(UtilClass.tourCost(route));
        TSPSolver tspSolver =new TSPSolver();
        tspSolver.solve(route);
        System.out.println(UtilClass.tourCost(route));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Visualize(route, route);
            }
        });
    }
}
