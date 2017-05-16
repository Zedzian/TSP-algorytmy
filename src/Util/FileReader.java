package Util;

import Data.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */
public class FileReader {

    private Scanner input = null;
    private int edgesCounter = 0;
    private List<Vertex> vertices = new ArrayList<>();

    public FileReader() {
    }

    public void registerData(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean readFile(String filename) {
        try {
            input = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        readHeader(input);
        readBody(input);
        return true;
    }

    private void readHeader(Scanner input) {
        String line = input.nextLine();
        edgesCounter = Integer.valueOf(line);
    }

    private void readBody(Scanner input) {
        String[] str = new String[2];
        for (int i = 0; i < edgesCounter; i++) {
            String line = input.nextLine();
            str = line.split("\\s");
            vertices.add(new Vertex(new BigDecimal(str[0]).doubleValue(), new BigDecimal(str[1]).doubleValue()));
        }
    }

}
