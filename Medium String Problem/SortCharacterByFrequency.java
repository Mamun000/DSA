import java.util.*;

public class SortCharacterByFrequency {
    // Brute Force Approach TC: O(NlogN) SC: O(N)
    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> charList = new ArrayList<>(freqMap.keySet());
        charList.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Optimal Approach TC: O(N) SC: O(N)
    public static String frequencySortOptimalApproach(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 26; i++) {
            int freq = count[i];
            if (freq > 0) {
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add((char) (i + 'a'));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(frequencySort(str));
        System.out.println(frequencySortOptimalApproach(str));
    }

}
