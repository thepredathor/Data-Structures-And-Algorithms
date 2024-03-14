
package data_structures.graphs.algorithms;

import java.util.HashMap;

import data_structures.graphs.UndirectedVertex;


public class DepthFirstSearch {

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

        depthFirstSearchPrint(alice, new HashMap<>());
        System.out.println();
        System.out.println("Depth first search!!");
        UndirectedVertex undirectedVertex = depthFirstSearch(alice, "Elaine", new HashMap<>());
        System.out.println("Vertex that contains value: Elaine has value: " + ((undirectedVertex == null) ? "No vertex" : undirectedVertex.value));
    }

    public static void depthFirstSearchPrint(UndirectedVertex vertex, HashMap<UndirectedVertex, Boolean> visitedVertices) {
        System.out.println(vertex.value);
        visitedVertices.put(vertex, true);

        for (UndirectedVertex v : vertex.adjacentVertices) {
            if (!visitedVertices.containsKey(v)) {
                depthFirstSearchPrint(v, visitedVertices);
            }
        }
    }

    public static UndirectedVertex depthFirstSearch(UndirectedVertex vertex, String searchValue, HashMap<UndirectedVertex, Boolean> visitedVertices) {
        if (searchValue.equals(vertex.value)) {
            return vertex;
        }

        System.out.println(vertex.value);
        visitedVertices.put(vertex, true);

        for (UndirectedVertex v : vertex.adjacentVertices) {
            if (!visitedVertices.containsKey(v)) {
                UndirectedVertex vertexToSearch = depthFirstSearch(v, searchValue, visitedVertices);
                if (vertexToSearch != null) {
                    return vertexToSearch;
                }
            }
        }

        return null;
    }
}
