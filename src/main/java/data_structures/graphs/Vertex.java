
package data_structures.graphs;

import java.util.ArrayList;


public class Vertex {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public String value;
    public ArrayList<Vertex> adjacentVertices = new ArrayList<>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public Vertex() {
    }

    public Vertex(String value) {
        this.value = value;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public void addAdjacentVertex(Vertex vertex) {
        this.adjacentVertices.add(vertex);
    }
}
