package blind75.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.compute(num, (key, value) -> (value == null) ? 1 : ++value);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> entries = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
            entries.add(entry);
        }

        int count = 0;
        int[] ints = new int[k];

        while (count < k) {
            ints[count] = entries.remove().getKey();
            count++;
        }

        return ints;
    }
}
