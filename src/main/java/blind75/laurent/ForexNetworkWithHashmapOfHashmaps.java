package blind75.laurent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ForexNetworkWithHashmapOfHashmaps {
    Map<String, Map<String, Float>> currency1ToCurrency2ToConversionRate = new HashMap<>();

    public Map<String, Map<String, Float>> convertStringToCurrencyMappings(String currencyMappings) {

        String[] splitTuples = currencyMappings.split(",");
        for(String splitTuple : splitTuples) {
            String[] split = splitTuple.split(":");
            Map<String, Float> mapping = this.currency1ToCurrency2ToConversionRate.getOrDefault(split[0], new HashMap<>());
            mapping.put(split[1], Float.parseFloat(split[2]));
            this.currency1ToCurrency2ToConversionRate.put(split[0], mapping);
            Map<String, Float> mapping2 = this.currency1ToCurrency2ToConversionRate.getOrDefault(split[1], new HashMap<>());
            mapping.put(split[0], 1/Float.parseFloat(split[2]));
            this.currency1ToCurrency2ToConversionRate.put(split[1], mapping2);
        }

        return currency1ToCurrency2ToConversionRate;
    }

    public void printCurrencyTuples() {
        for(Map.Entry<String, Map<String, Float>> currency1ToCurrency2 : currency1ToCurrency2ToConversionRate.entrySet()) {
            for(Map.Entry<String, Float> currency2 : currency1ToCurrency2.getValue().entrySet()) {
                System.out.format("%s, %s -> %s", currency1ToCurrency2.getKey(), currency2.getKey(), currency2.getValue());
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printConversionRateBetween2Currencies(String currency1, String currency2) {
        System.out.println("First problem: ");
        Float conversionRate = this.currency1ToCurrency2ToConversionRate.get(currency1).get(currency2);

        if(conversionRate == null) {
            conversionRate = this.currency1ToCurrency2ToConversionRate.get(currency2).get(currency1);
        }

        System.out.format("%s, %s -> %s", currency1, currency2, conversionRate);
        System.out.println();
    }

    public void printConversionRateBetween2CurrenciesWithIntermediate(String currency1, String currency2) {
        System.out.println("Second problem: ");
        Map<String, Float> currency1Mappings = this.currency1ToCurrency2ToConversionRate.get(currency1);

        for(Map.Entry<String, Float> currency1Mapping: currency1Mappings.entrySet()) {
            if(this.currency1ToCurrency2ToConversionRate.get(currency1Mapping.getKey()).containsKey(currency2)) {
                Float intermediateConversionRate = this.currency1ToCurrency2ToConversionRate.get(currency1Mapping.getKey()).get(currency2);
                System.out.format("%s, %s -> %s * %s = %s", currency1, currency2, currency1Mapping.getValue(), intermediateConversionRate, currency1Mapping.getValue() * intermediateConversionRate);
                System.out.println();
                break;
            }
        }
    }

    public void printConversionRateBetween2CurrenciesWithIntermediateMin(String currency1, String currency2) {
        System.out.println("Third problem: ");
        Float minIntermediateConversionRate = Float.MAX_VALUE;
        Map<String, Float> currency1Mappings = this.currency1ToCurrency2ToConversionRate.get(currency1);

        for(Map.Entry<String, Float> currency1Mapping: currency1Mappings.entrySet()) {
            if(this.currency1ToCurrency2ToConversionRate.get(currency1Mapping.getKey()).containsKey(currency2)) {
                Float intermediateConversionRate = this.currency1ToCurrency2ToConversionRate.get(currency1Mapping.getKey()).get(currency2);
                Float firstConversionRate = this.currency1ToCurrency2ToConversionRate.get(currency1).get(currency1Mapping.getKey());
                minIntermediateConversionRate = Math.min(minIntermediateConversionRate, intermediateConversionRate * firstConversionRate);
            }
        }

        System.out.format("%s, %s -> %s", currency1, currency2, minIntermediateConversionRate);
        System.out.println();
    }

    public static void main(String[] args) {
        ForexNetworkWithHashmapOfHashmaps forexNetworkWithHashmapOfHashmaps = new ForexNetworkWithHashmapOfHashmaps();
        forexNetworkWithHashmapOfHashmaps.convertStringToCurrencyMappings("AUD:RON:2.99,AUD:HUF:237.65,USD:CAD:1.36,USD:RON:4.59,USD:JPY:151.167,RON:MDL:3.86,HUF:MDL:0.05,MDL:RUB:5.23");
        forexNetworkWithHashmapOfHashmaps.printCurrencyTuples();

        //Solution 1
        forexNetworkWithHashmapOfHashmaps.printConversionRateBetween2Currencies("AUD", "RON");
        //Solution 2
        forexNetworkWithHashmapOfHashmaps.printConversionRateBetween2CurrenciesWithIntermediate("AUD", "MDL");
        //Solution 3
        forexNetworkWithHashmapOfHashmaps.printConversionRateBetween2CurrenciesWithIntermediateMin("AUD", "MDL");
    }
}
