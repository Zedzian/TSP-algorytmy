//package Logic.Genetic;
//
//import Data.Vertex;
//import Util.UtilClass;
//
//import java.util.List;
//import java.util.Random;
//
///**
// * Created by m.zedzian & 94lucasm on 10-05-2017.
// */
//public class GeneticAlgorithm {
//
//    Vertex temp = new Vertex(1, 1, 1);
//
//    private void swap(Vertex a, Vertex b) {
//
//        temp.setOther(a);
//        a.setOther(b);
//        b.setOther(temp);
//    }
//
//    public List<Vertex> crossing(List<Vertex> route) {
//
//        int AIndex = new Random().nextInt(390);
//        int BIndex = new Random().nextInt(390);
//        int CIndex = new Random().nextInt(390);
//        while (AIndex == BIndex || AIndex == CIndex || BIndex == CIndex) {
//            AIndex = new Random().nextInt(390);
//            BIndex = new Random().nextInt(390);
//            CIndex = new Random().nextInt(390);
//        }
//
//        int costBefore = UtilClass.tourCost(route);
//        int tourLength = new Random().nextInt(10);
//        swap(route.get(AIndex), route.get(currentVertexBIndex));
//        swap(route.get(currentVertexAIndex + tourLength), route.get(currentVertexBIndex + tourLength));
//        int costAfter = UtilClass.tourCost(route);
//        if (curCost > cost) {
//            swap(route.get(currentVertexAIndex), route.get(currentVertexBIndex));
//            swap(route.get(currentVertexAIndex + tourLength), route.get(currentVertexBIndex + tourLength));
//        }
//        System.out.println(route.size() + " " + currentVertexAIndex + " " + currentVertexBIndex + " " + tourLength);
//        return route;
//
//    }
//
//
//}
