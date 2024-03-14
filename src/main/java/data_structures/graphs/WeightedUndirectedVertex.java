
package data_structures.graphs;

import java.util.HashMap;
import java.util.Map;


public class WeightedUndirectedVertex {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public String value;
    public Map<WeightedUndirectedVertex, Integer> adjacentVerticesToWeights = new HashMap();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public void addAdjacentVertexWithWeight(WeightedUndirectedVertex weightedUndirectedVertex, int weight) {
        if (this.adjacentVerticesToWeights.containsKey(weightedUndirectedVertex)) {
            return;
        }
        this.adjacentVerticesToWeights.put(weightedUndirectedVertex, weight);
    }

}
