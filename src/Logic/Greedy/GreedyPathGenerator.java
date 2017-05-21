package Logic.Greedy;

import Data.Vertex;
import Util.UtilClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class GreedyPathGenerator {

    private int K, Pmax;
    private boolean[] used;
    private List<Vertex> vertices = null;
    private ArrayList<Vertex> newRoute;

    public GreedyPathGenerator(List<Vertex> vertices, int K, int Pmax) {
        this.K = K;
        this.Pmax = Pmax;
        this.vertices = vertices;
    }

    public List<Vertex> createPath(double x, double y) {
        if (K == 1) {
            int currentVertexIndex = 0;
            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).getX() == x && vertices.get(i).getY() == y) {
                    currentVertexIndex = i;
                    break;
                }
            }
            //currentVertexIndex = new Random().nextInt(vertices.size());
            used = new boolean[vertices.size()];
            newRoute = new ArrayList<Vertex>(vertices.size());
            newRoute.add(vertices.get(currentVertexIndex));
            used[currentVertexIndex] = true;
            Vertex currentVertex = vertices.get(currentVertexIndex);
            Vertex next = null;
            int distance = Integer.MAX_VALUE;
            int newDistance = Integer.MAX_VALUE;

            for (int i = 1; i < Pmax; i++) {
                distance = Integer.MAX_VALUE;
                int jIndex = 0;
                for (int j = 0; j < vertices.size(); j++) {
                    if (!used[j]) {
                        newDistance = UtilClass.calculateDistance(currentVertex, vertices.get(j));
                        if (newDistance < distance) {
                            distance = newDistance;
                            next = vertices.get(j);
                            jIndex = j;
                        }
                    }
                }
                newRoute.add(next);
                used[jIndex] = true;
                currentVertex = next;
            }
            newRoute.add(vertices.get(currentVertexIndex));
            return newRoute;
        } else {

        }
        return newRoute;
    }
}