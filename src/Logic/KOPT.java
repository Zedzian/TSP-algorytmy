package Logic;

import Data.Vertex;
import Util.UtilClass;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */

public class KOPT {


    Vertex temp = new Vertex(1, 1, 1);

    public KOPT() {
    }

    private void swap(Vertex a, Vertex b) {
        temp.setOther(a);
        a.setOther(b);
        b.setOther(temp);
    }

    public List<Vertex> linear2OPT(List<Vertex> route) {

        int bestScore = UtilClass.tourCost(route);
        int curScore = 0;
        for (int i = 0; i < route.size(); i++) {
            for (int j = i + 1; j < route.size(); j++) {
                swap(route.get(i), route.get(j));
                curScore = UtilClass.tourCost(route);
                System.out.print(curScore + " ");
                if (curScore < bestScore) {
                    bestScore = curScore;
                } else {
                    swap(route.get(i), route.get(j));
                }
            }
            System.out.println();
        }
        return route;
    }


    public List<Vertex> random2OPT(List<Vertex> route, Random rnd, int rep) {
        if (rep > 100) {
            return route;
        }
        int i = rnd.nextInt(route.size() - 1);
        int j = rnd.nextInt(route.size() - 1);
        int bestScore = UtilClass.tourCost(route);
        if (i == j) {
            return route;
        }
        Collections.swap(route, i, j);
        int curScore = UtilClass.tourCost(route);
        if (curScore < bestScore) {
            return route;
        } else {
            Collections.swap(route, j, i);
            rep++;
            return random2OPT(route, rnd, rep);
        }
    }

    public List<Vertex> iterate2OPTRandom(List<Vertex> route, int times) {
        Random rnd = new Random();
        for (int i = 0; i < times; i++) {
            route = random2OPT(route, rnd, 99);
        }
        return route;
    }
}