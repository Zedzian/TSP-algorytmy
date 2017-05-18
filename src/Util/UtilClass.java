package Util;

import Data.Vertex;
import java.util.List;

/**
 * Created by m.zedzian & 94lucasm on 10-05-2017.
 */

public class UtilClass {
    private UtilClass() {
    }

    public static int calculateDistance(Vertex a, Vertex b) {
        double xDiff = a.getX() - b.getX();
        double xSqr = Math.pow(xDiff, 2);
        double yDiff = a.getY() - b.getY();
        double ySqr = Math.pow(yDiff, 2);
        int output = (int) Math.sqrt(xSqr + ySqr);
        return output;
    }

    public static int tourCost(List<Vertex> tour) {
        int cost = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            cost += calculateDistance(tour.get(i), tour.get(i + 1));
        }
        cost += calculateDistance(tour.get(tour.size() - 1), tour.get(0));
        return cost;
    }
}