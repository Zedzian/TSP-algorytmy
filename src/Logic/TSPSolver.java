package Logic;

import Data.Vertex;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 17-05-2017.
 */

public class TSPSolver {

    List<Vertex> solution;

    public List<Vertex> solve(List<Vertex> route) {

        KOPT kopt = new KOPT();
        solution = kopt.linear2OPT(route);
        solution = kopt.iterate2OPTRandom(solution, 10000);
        return solution;
    }
}