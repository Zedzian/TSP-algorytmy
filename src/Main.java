import Util.FileReader;
import Data.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 14-05-2017.
 */
public class Main {

    private static List<Vertex> vertices = new ArrayList<>();
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        fileReader.registerData(vertices);
        fileReader.readFile("test.txt");


    }
}
