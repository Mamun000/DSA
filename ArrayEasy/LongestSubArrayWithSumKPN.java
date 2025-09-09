import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumKPN {
    public static void main(String[] args) {
        int numbers[] = { -1, 1, 1, 1, -1 };
        int k = 1;

        int ans = longestSubArrayWithSumKPN(numbers, k);
        System.out.println(ans);

        ans = longestSubArrayWithSumKPNOptimalApproach(numbers, k);
        System.out.println(ans);
    }
// Brute Force Approach TC : O(n^2) SC : O(1)
    public static int longestSubArrayWithSumKPN(int[] arr, int k) {
        int maxlen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }

        }
        return maxlen;
    }
// Optimal Approach TC : O(n) SC : O(n)
    public static int longestSubArrayWithSumKPNOptimalApproach(int[] arr, int k) {
        int maxlen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            int rem = sum - k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxlen;
    }

}
