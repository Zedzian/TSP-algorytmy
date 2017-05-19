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

    public static int calculateDistance(List<Vertex> route, Vertex a, Vertex b) {
        int output = 0;
        Vertex v = null;

        if (route.indexOf(a) > route.indexOf(b)) {
            double axDiff = a.getX() - route.get((route.indexOf(a) + 1)%UtilClass.tourCost(route)).getX();
            double axSqr = Math.pow(axDiff, 2);
            double ayDiff = a.getY() - route.get((route.indexOf(a) + 1)%UtilClass.tourCost(route)).getY();
            double aySqr = Math.pow(ayDiff, 2);
            output = (int) Math.sqrt(axSqr + aySqr);

            double bxDiff = b.getX() - route.get((route.indexOf(b) - 1)%UtilClass.tourCost(route)).getX();
            double bxSqr = Math.pow(bxDiff, 2);
            double byDiff = b.getY() - route.get((route.indexOf(b) - 1)%UtilClass.tourCost(route)).getY();
            double bySqr = Math.pow(byDiff, 2);
            output += (int) Math.sqrt(bxSqr + bySqr);
            return output;
        } else {
            double axDiff = a.getX() - route.get((route.indexOf(a) - 1)%UtilClass.tourCost(route)).getX();
            double axSqr = Math.pow(axDiff, 2);
            double ayDiff = a.getY() - route.get((route.indexOf(a) - 1)%UtilClass.tourCost(route)).getY();
            double aySqr = Math.pow(ayDiff, 2);
            output = (int) Math.sqrt(axSqr + aySqr);

            double bxDiff = b.getX() - route.get((route.indexOf(b) + 1)%UtilClass.tourCost(route)).getX();
            double bxSqr = Math.pow(bxDiff, 2);
            double byDiff = b.getY() - route.get((route.indexOf(b) + 1)%UtilClass.tourCost(route)).getY();
            double bySqr = Math.pow(byDiff, 2);
            output += (int) Math.sqrt(bxSqr + bySqr);
            return output;
        }
    }
    public static int calculateDistanceafterSwap(List<Vertex> route, Vertex a, Vertex b) {
        int output = 0;
        Vertex v = null;

        if (route.indexOf(a) > route.indexOf(b)) {
            double axDiff = a.getX() - route.get((route.indexOf(a) + 1)%UtilClass.tourCost(route)).getX();
            double axSqr = Math.pow(axDiff, 2);
            double ayDiff = a.getY() - route.get((route.indexOf(a) + 1)%UtilClass.tourCost(route)).getY();
            double aySqr = Math.pow(ayDiff, 2);
            output = (int) Math.sqrt(axSqr + aySqr);

            double bxDiff = b.getX() - route.get((route.indexOf(b) - 1)%UtilClass.tourCost(route)).getX();
            double bxSqr = Math.pow(bxDiff, 2);
            double byDiff = b.getY() - route.get((route.indexOf(b) - 1)%UtilClass.tourCost(route)).getY();
            double bySqr = Math.pow(byDiff, 2);
            output += (int) Math.sqrt(bxSqr + bySqr);
            return output;
        } else {
            double axDiff = a.getX() - route.get((route.indexOf(b) + 1)%UtilClass.tourCost(route)).getX();
            double axSqr = Math.pow(axDiff, 2);
            double ayDiff = a.getY() - route.get((route.indexOf(b) + 1)%UtilClass.tourCost(route)).getY();
            double aySqr = Math.pow(ayDiff, 2);
            output = (int) Math.sqrt(axSqr + aySqr);

            double bxDiff = b.getX() - route.get((route.indexOf(a) - 1)%UtilClass.tourCost(route)).getX();
            double bxSqr = Math.pow(bxDiff, 2);
            double byDiff = b.getY() - route.get((route.indexOf(a) - 1)%UtilClass.tourCost(route)).getY();
            double bySqr = Math.pow(byDiff, 2);
            output += (int) Math.sqrt(bxSqr + bySqr);
            return output;
        }
    }
}