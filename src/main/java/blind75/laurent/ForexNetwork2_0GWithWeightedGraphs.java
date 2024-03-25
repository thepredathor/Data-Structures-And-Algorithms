package blind75.laurent;

import java.util.HashMap;
import java.util.Map;

public class ForexNetwork2_0GWithWeightedGraphs {
    public static HashMap<String, ForexNetwork.ConversionRate> convertStringToCurrencyToConversionRateMap(String currencyTuples) {
        HashMap<String, ForexNetwork.ConversionRate> currencyToConversionRateMap = new HashMap<>();
        String[] splitTuples = currencyTuples.split(",");
        for(String splitTuple : splitTuples) {
            String[] split = splitTuple.split(":");
            currencyToConversionRateMap.put(split[0], new ForexNetwork.ConversionRate(split[1], Double.parseDouble(split[2])));
            currencyToConversionRateMap.put(split[1], new ForexNetwork.ConversionRate(split[0], 1/Double.parseDouble(split[2])));
        }

        return currencyToConversionRateMap;
    }
}

class WeightedNode {
    String currency;
    Map<WeightedNode, Double> conversionRates = new HashMap<>();

    public WeightedNode(String currency) {
        this.currency = currency;
    }

    public void add(WeightedNode weightedNode, double conversionRate) {
        conversionRates.put(weightedNode, conversionRate);
        weightedNode.conversionRates.put(this, 1/conversionRate);
    }
}
