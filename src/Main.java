
import Logic.GreedyPathGenerator;
import Logic.KOPT;
import Util.FileReader;
import Data.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 14-05-2017.
 */
public class Main {

    final static double x = 607.71;
    final static double y = 673.196;

    public static List<Vertex> vertices = new ArrayList<>();

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        fileReader.registerData(vertices);
        fileReader.readFile("test.txt");
        GreedyPathGenerator greedyPathGenerator = new GreedyPathGenerator(vertices);
        vertices = greedyPathGenerator.createPath(x, y);


    }

    public static List<Vertex> getVertices() {
        return vertices;
    }
}
