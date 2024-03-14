
package data_structures.graphs.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import data_structures.graphs.UndirectedVertex;
import data_structures.graphs.Vertex;


public class BreadthFirstSearch {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        UndirectedVertex alice = new UndirectedVertex("Alice");
        UndirectedVertex bob = new UndirectedVertex("Bob");
        UndirectedVertex candy = new UndirectedVertex("Candy");
        UndirectedVertex derek = new UndirectedVertex("Derek");
        UndirectedVertex elaine = new UndirectedVertex("Elaine");
        UndirectedVertex fred = new UndirectedVertex("Fred");
        UndirectedVertex helen = new UndirectedVertex("Helen");
        UndirectedVertex gina = new UndirectedVertex("Gina");
        UndirectedVertex irena = new UndirectedVertex("Irena");

        alice.addAdjacentVertex(bob);
        alice.addAdjacentVertex(candy);
        alice.addAdjacentVertex(derek);
        alice.addAdjacentVertex(elaine);
        bob.addAdjacentVertex(fred);
        fred.addAdjacentVertex(helen);
        candy.addAdjacentVertex(helen);
        derek.addAdjacentVertex(elaine);
        derek.addAdjacentVertex(gina);
        gina.addAdjacentVertex(irena);

        breadthFirstSearchPrint(alice);
        System.out.println();
        UndirectedVertex undirectedVertex = breadthFirstSearch(alice, "Elaine");
        System.out.println("Vertex that contains value: Elaine has value: " + ((undirectedVertex == null) ? "No vertex" : undirectedVertex.value));
    }

    public static void breadthFirstSearchPrint(UndirectedVertex vertex) {
        HashMap<UndirectedVertex, Boolean> visitedVertices = new HashMap<>();
        System.out.println(vertex.value);
        visitedVertices.put(vertex, true);

        Queue<UndirectedVertex> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            UndirectedVertex undirectedVertex = queue.remove();

            for (UndirectedVertex v : undirectedVertex.adjacentVertices) {
                if (!visitedVertices.containsKey(v)) {
                    System.out.println(v.value);
                    visitedVertices.put(v, true);
                    queue.add(v);
                }
            }
        }
    }

    public static UndirectedVertex breadthFirstSearch(UndirectedVertex vertex, String searchValue) {
        HashMap<UndirectedVertex, Boolean> visitedVertices = new HashMap<>();
        System.out.println(vertex.value);
        visitedVertices.put(vertex, true);

        LinkedList<UndirectedVertex> queue = new LinkedList<>();
        queue.addLast(vertex);

        while (!queue.isEmpty()) {
            UndirectedVertex vertexToBeSearched = queue.removeFirst();
            if (searchValue.equals(vertexToBeSearched.value)) {
                return vertexToBeSearched;
            }
            for (UndirectedVertex v : vertexToBeSearched.adjacentVertices) {
                if (!visitedVertices.containsKey(v)) {
                    System.out.println(v.value);
                    visitedVertices.put(v, true);
                    queue.addLast(v);
                }
            }
        }

        return null;
    }
}
