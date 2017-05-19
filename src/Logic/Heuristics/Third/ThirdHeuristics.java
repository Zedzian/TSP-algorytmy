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

public class ThirdHeuristics implements Heuristics {
    private int K, Pmax;
    private Vertex S;
    private List<Vertex> route;

    public ThirdHeuristics(List<Vertex> route, Vertex S, int K, int Pmax) {
        this.route = route;
        this.S = S;
        this.K = K;
        this.Pmax = Pmax;
    }

    public List<Vertex> generateRoute() {
        KOPT kopt = new KOPT();
        GreedyPathGenerator greedyPathGenerator;
        greedyPathGenerator = new GreedyPathGenerator(route, K, Pmax);
        route = greedyPathGenerator.createPath(S.getX(), S.getY());
        System.out.println(route.size());
        System.out.println("Tour cost after greedy algorithm: " + UtilClass.tourCost(route));
        route = kopt.linear2OPTwithRandomReplace(route);
        System.out.println("Tour cost after 2OPT algorithm: " + UtilClass.tourCost(route));
        return route;
    }
}
