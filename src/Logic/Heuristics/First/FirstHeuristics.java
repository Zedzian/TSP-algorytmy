package Logic.Heuristics.First;

import Data.Vertex;
import Logic.Heuristics.Heuristics;
import Logic.Heuristics.KOPT;
import Logic.Random.RandomPathGenerator;
import Util.UtilClass;

import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class FirstHeuristics implements Heuristics {

    private RandomPathGenerator randomPathGenerator = null;
    private KOPT kopt = null;
    private double x, y;
    private int index = 0;
    private int minCost, N;
    private List<Vertex> route = null, output;

    public FirstHeuristics(List<Vertex> route, double x, double y) {
        this.route = route;
        this.x = x;
        this.y = y;
    }

    public List<Vertex> generateRoute() {
        output = route;
        minCost = UtilClass.tourCost(route);
        randomPathGenerator = new RandomPathGenerator(route);
        kopt = new KOPT();
        N = new Random().nextInt(50);
        N = 4;
        while (index != N) {
            route = randomPathGenerator.createPath(x, y);
            for (int i = 0; i < 15; i++) {
                route = kopt.linear2OPT(route);
                System.out.println(UtilClass.tourCost(route) + " " + minCost);
            }
            System.out.println();
            if (UtilClass.tourCost(route) < minCost) {
                output = route;
                minCost = UtilClass.tourCost(route);
            }
            index++;
        }
        System.out.println(UtilClass.tourCost(route) + " " + minCost);
        return output;
    }


}
