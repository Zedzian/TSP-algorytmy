package Logic.Heuristics.Second;

import Data.Vertex;
import Logic.Greedy.GreedyPathGenerator;
import Logic.Heuristics.Heuristics;
import Logic.Heuristics.KOPT;
import Util.UtilClass;

import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class SecondHeuristics implements Heuristics {
    private double x, y;
    private List<Vertex> solution, route;

    public SecondHeuristics(List<Vertex> route, double x, double y) {
        this.route = route;
    }

    public List<Vertex> generateRoute() {
        KOPT kopt = new KOPT();
        solution = kopt.linear2OPT(route);
        GreedyPathGenerator greedyPathGenerator;
        while (UtilClass.tourCost(route) >= 18100) {
            greedyPathGenerator = new GreedyPathGenerator(route);
            route = greedyPathGenerator.createPath(x, y);
            route.add(new Vertex(x, y));
            //System.out.println(UtilClass.tourCost(route));
            route = kopt.linear2OPT(route);
            //System.out.println(UtilClass.tourCost(route));
        }
        return route;
    }
}
