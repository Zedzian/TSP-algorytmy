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

    private boolean[] used;
    private List<Vertex> vertices = null;

    public GreedyPathGenerator(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertex> createPath(double x, double y) {

        int currentVertexIndex = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getX() == x && vertices.get(i).getY() == y) {
                currentVertexIndex = i;
                break;
            }
        }
        currentVertexIndex = new Random().nextInt(vertices.size());
        used = new boolean[vertices.size()];
        ArrayList<Vertex> newRoute = new ArrayList<Vertex>(vertices.size());
        newRoute.add(vertices.get(currentVertexIndex));
        used[currentVertexIndex] = true;
        Vertex currentVertex = vertices.get(currentVertexIndex);
        Vertex next = null;
        int distance = Integer.MAX_VALUE;
        int newDistance = Integer.MAX_VALUE;

        for (int i = 1; i < vertices.size(); i++) {
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
            //System.out.println(newRoute.get(i - 1).getX() + " " + newRoute.get(i - 1).getY());
        }
        newRoute.add(vertices.get(currentVertexIndex));
        return newRoute;
    }
}