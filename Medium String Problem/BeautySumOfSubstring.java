import java.util.HashMap;
import java.util.Map;

public class BeautySumOfSubstring {
    public static int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Loop through all substrings
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();

            for (int j = i; j < n; j++) {
                // Increase character frequency
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                // Calculate max and min frequency
                for (int val : freq.values()) {
                    mini = Math.min(mini, val);
                    maxi = Math.max(maxi, val);
                }

                // Add to sum
                sum += (maxi - mini);
            }
        }

        return sum;
        }
    public static void main(String[] args) {
        String s = "xyx";
        System.out.println("Beauty Sum: " + beautySum(s));
    }
    
}
