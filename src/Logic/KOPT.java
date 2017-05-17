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

    public List<Vertex> linear2OPT(List<Vertex> copy) {

        int bestScore = UtilClass.tourCost(copy);
        boolean noChange = false;
        int curScore = 0;

        for (int i = 0; i < copy.size(); i++) {
            for (int j = i + 1; j < copy.size(); j++) {
                swap(copy.get(i), copy.get(j));
                curScore = UtilClass.tourCost(copy);
                if (curScore < bestScore) {
                    bestScore = curScore;
                } else {
                    //Reverse changes
                    swap(copy.get(i), copy.get(j));
                }
            }
        }
        return copy;
    }


    public List<Vertex> random2OPT(List<Vertex> copy, Random rnd, int rep) {
        if (rep > 100) {
            return copy;
        }
        int i = rnd.nextInt(copy.size() - 1);
        int j = rnd.nextInt(copy.size() - 1);

        int bestScore = UtilClass.tourCost(copy);

        if (i == j) {
            return copy;
        }
        Collections.swap(copy, i, j);
        int curScore = UtilClass.tourCost(copy);

        if (curScore < bestScore) {
            return copy;
        } else {
            Collections.swap(copy, j, i);
            rep++;
            return random2OPT(copy, rnd, rep);
        }
    }

    public List<Vertex> iterate2OPTRandom(List<Vertex> initial, int times) {
        Random rnd = new Random();
        for (int i = 0; i < times; i++) {
            initial = random2OPT(initial, rnd, 99);
        }
        return initial;
    }


}