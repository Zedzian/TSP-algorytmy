package Logic.Random;

import Data.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */

public class RandomPathGenerator {

    private boolean[] used;
    private int Pmax;
    private List<Vertex> vertices = null;

    public RandomPathGenerator(List<Vertex> vertices, int Pmax) {
        this.vertices = vertices;
        this.Pmax = Pmax;
    }

    public ArrayList<Vertex> createPath(double x, double y) {

        int currentVertexIndex = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getX() == x && vertices.get(i).getY() == y) {
                currentVertexIndex = i;
                break;
            }
        }
        used = new boolean[vertices.size()];
        ArrayList<Vertex> newRoute = new ArrayList<Vertex>(vertices.size());
        newRoute.add(vertices.get(currentVertexIndex));
        used[currentVertexIndex] = true;
        System.out.println("size: " + vertices.size());
        for (int i = 1; i < vertices.size(); i++) {
            int random = new Random().nextInt(Pmax);
            while (used[random]) {
                random = new Random().nextInt(Pmax);
            }
            newRoute.add(vertices.get(random));
            //System.out.println(vertices.get(random));
            used[random] = true;
        }
        newRoute.add(vertices.get(currentVertexIndex));
        return newRoute;
    }
}