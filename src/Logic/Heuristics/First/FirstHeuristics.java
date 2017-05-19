package Logic.Heuristics.First;

import Data.Vertex;
import Logic.Heuristics.Heuristics;
import Logic.Heuristics.KOPT;
import Logic.Random.RandomPathGenerator;
import Util.UtilClass;

import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class FirstHeuristics implements Heuristics {

    private int K, Pmax, index = 0, minCost, N;
    private double x, y;
    private Vertex S;
    private RandomPathGenerator randomPathGenerator = null;
    private KOPT kopt = null;
    private List<Vertex> route = null, output;

    public FirstHeuristics(List<Vertex> route, Vertex S, int K, int Pmax) {
        this.route = route;
        this.S = S;
        this.K = K;
        this.Pmax = Pmax;
    }

    public List<Vertex> generateRoute() {
        output = route;
        minCost = UtilClass.tourCost(route);
        randomPathGenerator = new RandomPathGenerator(route, Pmax);
        kopt = new KOPT();
        route = randomPathGenerator.createPath(S.getX(), S.getY());
        route = kopt.linear2OPT(route);
        return route;
    }


}
