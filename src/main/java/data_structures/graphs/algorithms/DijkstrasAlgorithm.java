
package data_structures.graphs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data_structures.graphs.WeightedVertex;


public class DijkstrasAlgorithm {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    Map<WeightedVertex, Integer> graphTraversalNodeOrderWithWeights = new LinkedHashMap<>();
    Map<WeightedVertex, Integer> shortestPathToVertexFromStartingVertex = new HashMap<>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
//        WeightedVertex atlanta = new WeightedVertex("Atlanta");
//        WeightedVertex boston = new WeightedVertex("Boston");
//        WeightedVertex chicago = new WeightedVertex("Chicago");
//        WeightedVertex denver = new WeightedVertex("Denver");
//        WeightedVertex elPaso = new WeightedVertex("El Paso");
//
//        atlanta.addAdjacentVertexWithWeight(boston, 100);
//        atlanta.addAdjacentVertexWithWeight(denver, 160);
//        boston.addAdjacentVertexWithWeight(chicago, 120);
//        boston.addAdjacentVertexWithWeight(denver, 180);
//        chicago.addAdjacentVertexWithWeight(elPaso, 80);
//        denver.addAdjacentVertexWithWeight(chicago, 40);
//        denver.addAdjacentVertexWithWeight(elPaso, 140);
//
//        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
//        dijkstrasAlgorithm.dijkstrasAlgorithm(atlanta);
//        dijkstrasAlgorithm.printGraphTraversalNodeOrderWithWeights(atlanta);
//        dijkstrasAlgorithm.printShortestPathToVertexFromStartingVertex(atlanta);
//        System.out.println();

        WeightedVertex a = new WeightedVertex("A");
        WeightedVertex b = new WeightedVertex("B");
        WeightedVertex c = new WeightedVertex("C");
        WeightedVertex d = new WeightedVertex("D");
        WeightedVertex e = new WeightedVertex("E");
        WeightedVertex f = new WeightedVertex("F");

        a.addAdjacentVertexWithWeight(b, 4);
        a.addAdjacentVertexWithWeight(c, 2);
        b.addAdjacentVertexWithWeight(c, 3);
        b.addAdjacentVertexWithWeight(d, 2);
        b.addAdjacentVertexWithWeight(e, 3);
        c.addAdjacentVertexWithWeight(b, 1);
        c.addAdjacentVertexWithWeight(d, 4);
        c.addAdjacentVertexWithWeight(e, 5);
        e.addAdjacentVertexWithWeight(d, 1);
        e.addAdjacentVertexWithWeight(f, 5);

        DijkstrasAlgorithm dijkstrasAlgorithm2 = new DijkstrasAlgorithm();
        dijkstrasAlgorithm2.dijkstrasAlgorithm(a);
        dijkstrasAlgorithm2.printGraphTraversalNodeOrderWithWeights(a);
        dijkstrasAlgorithm2.printShortestPathToVertexFromStartingVertex(a);
    }

    public void dijkstrasAlgorithm(WeightedVertex startingVertex) {
        //J-
        Map<WeightedVertex, Boolean> visitedVertices = new HashMap<>();

        WeightedVertex currentVertex = startingVertex;
        this.shortestPathToVertexFromStartingVertex.put(startingVertex, 0);
        this.graphTraversalNodeOrderWithWeights.put(startingVertex, 0);

        while (currentVertex != null) {
            visitedVertices.put(currentVertex, true);
            Map<WeightedVertex, Integer> unvisitedNeighbors = currentVertex.adjacentVerticesToWeights.entrySet().stream()
                    .filter(entry -> !visitedVertices.containsKey(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry<WeightedVertex, Integer> weightedVertexIntegerEntry : unvisitedNeighbors.entrySet()) {
                WeightedVertex adjacentVertex = weightedVertexIntegerEntry.getKey();
                Integer adjacentVertexWeight = weightedVertexIntegerEntry.getValue();
                Integer shortestPathToAdjacentVertex = this.shortestPathToVertexFromStartingVertex.get(adjacentVertex);
                Integer weightUntilCurrentVertex = this.shortestPathToVertexFromStartingVertex.get(currentVertex);
                if (shortestPathToAdjacentVertex == null) {
                    this.shortestPathToVertexFromStartingVertex.put(adjacentVertex, weightUntilCurrentVertex + adjacentVertexWeight);
                } else {
                    if (shortestPathToAdjacentVertex > (weightUntilCurrentVertex + adjacentVertexWeight)) {
                        this.shortestPathToVertexFromStartingVertex.compute(adjacentVertex, (key, value) -> weightUntilCurrentVertex + adjacentVertexWeight);
                    }
                }
            }

            WeightedVertex previousVertex = currentVertex;
            currentVertex = this.shortestPathToVertexFromStartingVertex.entrySet().stream()
                    .filter(entry -> !visitedVertices.containsKey(entry.getKey()))
                    .min(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            if(previousVertex != null && currentVertex != null) {
                this.graphTraversalNodeOrderWithWeights.put(currentVertex, previousVertex.adjacentVerticesToWeights.get(currentVertex));
            }

            //J+
        }
    }

    public void printGraphTraversalNodeOrderWithWeights(WeightedVertex startingVertex) {
        System.out.println("Shortest path taken for above graph from starting node: " + startingVertex.value);
        this.graphTraversalNodeOrderWithWeights.forEach((node, weight) -> System.out.println("node: " + node.value + ", with weight: " + weight));
    }

    public void printShortestPathToVertexFromStartingVertex(WeightedVertex startingVertex) {
        System.out.println("Shortest path weight sum for each node starting from node: " + startingVertex.value);
        this.shortestPathToVertexFromStartingVertex.forEach((node, weight) -> System.out.println("node: " + node.value + ", with weight: " + weight));
    }

//    public static List<String> dijkstrasAlgorithm(WeightedVertex startingVertex, WeightedVertex finalVertex) {
//        Map<WeightedVertex, Integer> smallestWeights = new HashMap<>();
//        Map<String, String> smallestWeightsPreviousVertices = new HashMap<>();
//
//        List<WeightedVertex> unvisitedVertices = new ArrayList<>();
//        Map<WeightedVertex, Boolean> visitedVertices = new HashMap<>();
//
//        smallestWeights.put(startingVertex, 0);
//        WeightedVertex currentVertex = startingVertex;
//
//        while (currentVertex != null) {
//            visitedVertices.put(currentVertex, true);
//
//            for (Map.Entry<WeightedVertex, Integer> adjacentVertex : currentVertex.adjacentVerticesToWeights.entrySet()) {
//                if (!visitedVertices.containsKey(adjacentVertex.getKey())) {
//                    unvisitedVertices.add(adjacentVertex.getKey());
//                }
//
//                int weightFromStartingVertexToCurrentVertex = smallestWeights.getOrDefault(currentVertex, 0) + adjacentVertex.getValue();
//
//                if ((smallestWeights.get(adjacentVertex.getKey()) == null) || (weightFromStartingVertexToCurrentVertex < smallestWeights.get(adjacentVertex.getKey()))) {
//                    smallestWeights.put(adjacentVertex.getKey(), weightFromStartingVertexToCurrentVertex);
//                    smallestWeightsPreviousVertices.put(adjacentVertex.getKey().value, currentVertex.value);
//                }
//            }
//
//            currentVertex = smallestWeights.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
//        }
//
//        List<String> shortestPath = new ArrayList<>();
//        String currentVertexValue = finalVertex.value;
//
//        while (!currentVertexValue.equals(startingVertex.value)) {
//            shortestPath.add(currentVertexValue);
//            currentVertexValue = smallestWeightsPreviousVertices.get(currentVertexValue);
//        }
//        shortestPath.add(startingVertex.value);
//
//        Collections.reverse(shortestPath);
//
//        return shortestPath;
//    }
}
