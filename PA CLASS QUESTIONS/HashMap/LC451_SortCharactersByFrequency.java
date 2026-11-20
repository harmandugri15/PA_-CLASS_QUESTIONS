// LeetCode 451: Sort Characters By Frequency
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC451_SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Bucket sort based on frequencies
        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int count = 0; count < i; count++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Characters sorted by frequency: " + frequencySort(s)); // "eert" or "eetr"
    }
}
