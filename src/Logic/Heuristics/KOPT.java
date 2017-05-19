package Logic.Heuristics;

import Data.Vertex;
import Util.UtilClass;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class KOPT {


    Vertex temp = new Vertex(1, 1, 1);
    int AIndex = 0, BIndex = 0;

    public KOPT() {
    }

    private void swap(Vertex a, Vertex b) {
        temp.setOther(a);
        a.setOther(b);
        b.setOther(temp);
    }

    private void swap3OPT(Vertex a, Vertex b, Vertex c) {
        temp.setOther(a);
        a.setOther(b);
        b.setOther(c);
        c.setOther(temp);
    }

    public List<Vertex> linear2OPT(List<Vertex> route) {

        int bestScore = UtilClass.tourCost(route);
        int curCost = 0, costSwap = 0;
        for (int i = 0; i < route.size(); i++) {
            for (int j = i + 1; j < route.size(); j++) {
                swap(route.get(i), route.get(j));
                curCost = UtilClass.tourCost(route);

                if (curCost < bestScore) {
                    bestScore = curCost;
                } else {
                    swap(route.get(i), route.get(j));
                }

            }
            swapOperator(route);
            costSwap = UtilClass.tourCost(route);
            //System.out.println(AIndex + " " + BIndex + " " + costSwap);
            if (costSwap > bestScore) {
                swap(route.get(BIndex), route.get(AIndex));
            }
            //if(i>route.size()/2 && bestScore>78000) break;
        }
        return route;
    }

    public List<Vertex> linear2OPTtoFirstLessCost(List<Vertex> route) {

        int bestCost = UtilClass.tourCost(route);
        int curCost = 0;
        for (int i = 0; i < route.size(); i++) {
            for (int j = i + 1; j < route.size(); j++) {
                random2OPT(route, 0);
                swap(route.get(i), route.get(j));
                curCost = UtilClass.tourCost(route);
                //System.out.print(curCost + " ");
                if (curCost < bestCost) {
                    bestCost = curCost;
                    break;
                } else {
                    swap(route.get(i), route.get(j));

                }
            }
            //System.out.println();
        }
        return route;
    }

    public List<Vertex> linear3OPT(List<Vertex> route) {

        int bestCost = UtilClass.tourCost(route);
        int curCost = 0;

        for (int i = 0; i < route.size(); i++) {
            for (int j = 0; j < route.size(); j++) {
                for (int k = 0; k < route.size(); k++) {
                    swap3OPT(route.get(i), route.get(j), route.get(k));
                    curCost = UtilClass.tourCost(route);
                    //System.out.println(curCost + " "+k);
                    if (curCost < bestCost) {
                        bestCost = curCost;
                        break;
                    } else {
                        //swap3OPT(route.get(i), route.get(j), route.get(k));
                    }
                }
                System.out.println();
            }
        }
        return route;
    }


    public List<Vertex> random2OPT(List<Vertex> route, int rep) {

        Random rnd = new Random();
        if (rep > 10) {
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
            rep++;
            return random2OPT(route, rep);
        } else {
            Collections.swap(route, j, i);
            rep++;
            return random2OPT(route, rep);
        }
    }

    public List<Vertex> iterate2OPTRandom(List<Vertex> route, int times) {
        for (int i = 0; i < times; i++) {
            route = random2OPT(route, 0);
        }
        return route;
    }

    public void swapOperator(List<Vertex> route) {
        AIndex = new Random().nextInt(400);
        BIndex = new Random().nextInt(400);
        swap(route.get(AIndex), route.get(BIndex));
    }
}