import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    //DSA
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> valueWeightMap = new HashMap<>();

        // Process items1
        for (int[] item : items1) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Process items2
        for (int[] item : items2) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Convert the map to a sorted list of lists
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueWeightMap.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }

        // Sort the result based on the value (first element)
        Collections.sort(result, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        return result;
    }
}
