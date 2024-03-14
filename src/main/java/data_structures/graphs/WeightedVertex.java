
package data_structures.graphs;

import java.util.HashMap;
import java.util.Map;


public class WeightedVertex {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public String value;
    public Map<WeightedVertex, Integer> adjacentVerticesToWeights = new HashMap<>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public WeightedVertex(String value) {
        this.value = value;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public void addAdjacentVertexWithWeight(WeightedVertex vertex, int weight) {
        if (this.adjacentVerticesToWeights.containsKey(vertex)) {
            return;
        }
        adjacentVerticesToWeights.put(vertex, weight);
    }
}
