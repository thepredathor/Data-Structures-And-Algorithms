package blind75.laurent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ForexNetwork {

    HashMap<CurrencyTuple, Double> currencyTupleLongHashMap;
    HashMap<String, ConversionRate> currencyOneToConversionRate;
    public static void main(String[] args) {
        ForexNetwork forexNetwork = new ForexNetwork();
        String currencyRateTuples = "AUD:RON:2.99,AUD:HUF:237.65,USD:CAD:1.36,USD:RON:4.59,USD:JPY:151.167,RON:MDL:3.86,HUF:MDL:0.05,MDL:RUB:5.23";
        String currencyRateTuples2 = "AUD:RON:2.99,AUD:HUF:237.65,USD:CAD:1.36,USD:RON:4.59,USD:JPY:151.167,RON:MDL:3.86,HUF:MDL:0.05,MDL:RUB:5.23";
        forexNetwork.currencyTupleLongHashMap = convertStringToTuples(currencyRateTuples);
        forexNetwork.currencyOneToConversionRate = convertStringToCurrencyToConversionRateMap(currencyRateTuples2);
        forexNetwork.printConversionRateBetweenCurrencies("AUD", "RON");
        forexNetwork.printConversionRateBetweenCurrencies("RON", "AUD");

        forexNetwork.printConversionRateBetweenCurrenciesWithIntermediate("AUD", "MDL");

    }

    public static class ConversionRate {
        public String currency;
        public double conversionRate;

        public ConversionRate(String currency, double conversionRate) {
            this.currency = currency;
            this.conversionRate = conversionRate;
        }
    }

    public static class CurrencyTuple {
        public String firstCurrency;
        public String secondCurrency;

        public CurrencyTuple(String firstCurrency, String secondCurrency) {
            this.firstCurrency = firstCurrency;
            this.secondCurrency = secondCurrency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CurrencyTuple that = (CurrencyTuple) o;
            return Objects.equals(firstCurrency, that.firstCurrency) && Objects.equals(secondCurrency, that.secondCurrency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstCurrency, secondCurrency);
        }
    }

    public static HashMap<CurrencyTuple, Double> convertStringToTuples(String currencyTuples) {
        HashMap<CurrencyTuple, Double> currencyTupleToRate = new HashMap<>();
        String[] splitTuples = currencyTuples.split(",");
        for(String splitTuple : splitTuples) {
            String[] split = splitTuple.split(":");
            currencyTupleToRate.put(new CurrencyTuple(split[0], split[1]), Double.parseDouble(split[2]));
            currencyTupleToRate.put(new CurrencyTuple(split[1], split[0]), 1/Double.parseDouble(split[2]));
        }

        return currencyTupleToRate;
    }

    public static HashMap<String, ConversionRate> convertStringToCurrencyToConversionRateMap(String currencyTuples) {
        HashMap<String, ConversionRate> currencyToConversionRateMap = new HashMap<>();
        String[] splitTuples = currencyTuples.split(",");
        for(String splitTuple : splitTuples) {
            String[] split = splitTuple.split(":");
            currencyToConversionRateMap.put(split[0], new ConversionRate(split[1], Double.parseDouble(split[2])));
            currencyToConversionRateMap.put(split[1], new ConversionRate(split[0], 1/Double.parseDouble(split[2])));
        }

        return currencyToConversionRateMap;
    }

    public static CurrencyTuple transformStringToCurrencyTuple(String currencyTuple) {
        String[] splitTuple = currencyTuple.split(":");
        return new CurrencyTuple(splitTuple[0], splitTuple[1]);
    }

    public void printConversionRateBetweenCurrencies(String currency1, String currency2) {
        CurrencyTuple currencyTuple = new CurrencyTuple(currency1, currency2);
        Double currencyRate = this.currencyTupleLongHashMap.get(currencyTuple);

        if(currencyRate != null) {
            System.out.format("Currency rate between %s and %s is %s:", currency1, currency2, currencyRate);
        }
        System.out.println();
    }

    public void printConversionRateBetweenCurrencies2(String currency1, String currency2) {
        CurrencyTuple currencyTuple = new CurrencyTuple(currency1, currency2);
        Double currencyRate = this.currencyTupleLongHashMap.get(currencyTuple);

        if(currencyRate != null) {
            System.out.format("Currency rate between %s and %s is %s:", currency1, currency2, currencyRate);
        }
        System.out.println();
    }

    public void printConversionRateBetweenCurrenciesWithIntermediate(String currency1, String currency2) {
        CurrencyTuple currencyTuple = new CurrencyTuple(currency1, currency2);
        Double currencyRate = this.currencyTupleLongHashMap.get(currencyTuple);

        if(currencyRate != null) {
            System.out.format("Currency rate between %s and %s is %s:", currency1, currency2, currencyRate);
        }

       List<CurrencyTuple> mappings1 = this.currencyTupleLongHashMap.entrySet().stream()
                .filter(entry -> currency1.equals(entry.getKey().firstCurrency))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        List<String> mappings2 = this.currencyTupleLongHashMap.entrySet().stream()
                .filter(entry -> currency2.equals(entry.getKey().secondCurrency))
                .map(entry -> entry.getKey())
                .map(currencyTuple1 -> currencyTuple1.firstCurrency)
                .collect(Collectors.toList());

        mappings1.stream().filter(mapping -> mappings2.contains(mapping.secondCurrency));

//        mappings1.

//        System.out.println();
    }
}
