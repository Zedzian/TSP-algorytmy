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
    private boolean isNoChange = false;

    public KOPT() {
    }

    private void swap(Vertex a, Vertex b) {
        temp.setOther(a);
        a.setOther(b);
        b.setOther(temp);
    }

    private List<Vertex> swapRandom(List<Vertex> route) {
        int i = new Random().nextInt(route.size());
        int j = new Random().nextInt(route.size());
        temp.setOther(route.get(j));
        route.get(j).setOther(route.get(i));
        route.get(i).setOther(temp);
        return route;
    }

    private void swap3OPT(Vertex a, Vertex b, Vertex c) {
        temp.setOther(a);
        a.setOther(b);
        b.setOther(c);
        c.setOther(temp);
    }

    public List<Vertex> linear2OPT(List<Vertex> route) {

        int bestScore, curCost = 0, costAfter2OPT = 0;
        int cost = UtilClass.tourCost(route);
        while (!isNoChange) {
            cost = UtilClass.tourCost(route);
            for (int i = 1; i < route.size() - 1; i++) {
                for (int j = 1; j < route.size() - 1; j++) {
                    if (i != j) {
                        //System.out.println(i+" "+j);
                        curCost = UtilClass.calculateDistance(route, route.get(i), route.get(j));
                        bestScore = UtilClass.calculateDistanceafterSwap(route, route.get(j), route.get(i));
                        //System.out.println(i + " " + j + " " + curCost + " " + bestScore);
                        if (curCost > bestScore) {
                            //System.out.println("kkkk");
                            route = swap2OPT(route, route.get(i), route.get(j));
                        }

                    }
                }
            }
            costAfter2OPT = UtilClass.tourCost(route);
            System.out.println(costAfter2OPT);
            if (cost <= costAfter2OPT) {

                isNoChange = true;
            }
        }
        return route;
    }

    public List<Vertex> linear2OPTwithRandomReplace(List<Vertex> route) {

        int bestScore, curCost = 0, costAfter2OPT = 0;
        int cost = UtilClass.tourCost(route);
        while (!isNoChange) {
            cost = UtilClass.tourCost(route);
            if (new Random().nextInt(10) == 5) {
                route = swapRandom(route);
            }
            for (int i = 1; i < route.size() - 1; i++) {
                for (int j = 1; j < route.size() - 1; j++) {
                    if (i != j) {
                        //System.out.println(i+" "+j);
                        curCost = UtilClass.calculateDistance(route, route.get(i), route.get(j));
                        bestScore = UtilClass.calculateDistanceafterSwap(route, route.get(j), route.get(i));
                        //System.out.println(i + " " + j + " " + curCost + " " + bestScore);
                        if (curCost > bestScore) {
                            //System.out.println("kkkk");
                            route = swap2OPT(route, route.get(i), route.get(j));
                        }

                    }
                }
            }
            costAfter2OPT = UtilClass.tourCost(route);
            System.out.println(costAfter2OPT);
            if (cost < costAfter2OPT) {
                route = linear2OPT(route);
            }
            if(cost == costAfter2OPT){
                isNoChange = true;
            }
        }
        return route;
    }

    private List<Vertex> swap2OPT(List<Vertex> route, Vertex a, Vertex b) {
        int aIndex = route.indexOf(a);
        int bIndex = route.indexOf(b);
        int temp;
        if (aIndex > bIndex) {
            temp = aIndex;
            aIndex = bIndex;
            bIndex = temp;
        }
        int times = (bIndex - aIndex + 2);
        for (int i = 0; i < times / 2; i++) {
            //System.out.println(aIndex + " " + route.get(aIndex).toString() + " " + bIndex + " " + route.get(bIndex).toString());
            swap(route.get(aIndex++), route.get(bIndex--));
            //System.out.println(route.get(aIndex - 1).toString() + " " + route.get(bIndex + 1).toString());
        }
        return route;
    }

    public List<Vertex> insert(List<Vertex> route) {

        int bestScore, curCost;
        for (int i = 0; i < route.size(); i++) {
            for (int j = i + 1; j < route.size() - 1; j++) {
                bestScore = UtilClass.tourCost(route);
                Vertex v = route.get(j);
                route.remove(v);
                route.add(i, v);
                curCost = UtilClass.tourCost(route);
                if (curCost < bestScore) {
                    bestScore = curCost;
                } else {
                    route.remove(v);
                    route.add(j, v);
                }
            }
            //if(i>route.size()/2 && bestScore>78000) break;
        }
        return route;
    }

    public List<Vertex> replace(List<Vertex> route) {
        int i = new Random().nextInt(route.size());
        int j = new Random().nextInt(route.size());
        System.out.println(i + " " + j);
        Vertex v = route.get(j);
        route.remove(v);
        route.add(i, v);
        return route;
    }

    public List<Vertex> linear2OPTtoFirstLessCost(List<Vertex> route) {

        int bestCost = UtilClass.tourCost(route);
        int curCost = 0;

        for (int k = 0; k < 15; k++) {
            for (int i = 0; i < route.size(); i++) {
                for (int j = i + 1; j < route.size(); j++) {
                    random2OPT(route, 0);
                    swap(route.get(i), route.get(j));
                    curCost = UtilClass.tourCost(route);
                    System.out.println(curCost + " curCost");
                    if (curCost < bestCost) {
                        bestCost = curCost;
                        break;
                    } else {
                        swap(route.get(i), route.get(j));

                    }
                }
                System.out.println();
            }
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