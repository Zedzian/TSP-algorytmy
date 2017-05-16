package Util;

import Data.Vertex;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */
public class UtilClass {
    private UtilClass() {
    }

    public static double calculateDistance(Vertex a, Vertex b) {
        double xDiff = a.getX() - b.getY();
        double xSqr = Math.pow(xDiff, 2);

        double yDiff = a.getX() - b.getY();
        double ySqr = Math.pow(yDiff, 2);

        double output = Math.sqrt(xSqr + ySqr);

        return output;
    }
}
