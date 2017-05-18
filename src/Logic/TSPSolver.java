package Logic;

import Data.Vertex;
//import Logic.Genetic.GeneticAlgorithm;

import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class TSPSolver {

    List<Vertex> solution;

    public List<Vertex> solve(List<Vertex> route) {

        KOPT kopt = new KOPT();
        //GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        for (int i = 0; i < 50; i++) {
            //solution = geneticAlgorithm.crossing(route);
        }
        for (int i = 0; i < 8; i++) {
            solution = kopt.linear2OPT(route);
        }
        return solution;
    }
}