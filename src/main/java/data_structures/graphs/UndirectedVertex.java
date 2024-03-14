
package data_structures.graphs;

import java.util.ArrayList;


public class UndirectedVertex {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public String value;
    public ArrayList<UndirectedVertex> adjacentVertices = new ArrayList<>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public UndirectedVertex(String value) {
        this.value = value;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public void addAdjacentVertex(UndirectedVertex vertex) {
        if (this.adjacentVertices.contains(vertex)) {
            return;
        }

        this.adjacentVertices.add(vertex);
        vertex.addAdjacentVertex(this);
    }
}
