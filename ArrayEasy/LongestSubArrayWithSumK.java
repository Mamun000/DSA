import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int numbers[] = { 1, 0, 2, 2, 3, 5 };
        int k = 5;

        int ans = longestSubarrayWithSumK(numbers, k);
        System.out.println(ans);

        ans = longestSubarrayWithSumKOptimalApproach(numbers, k);
        System.out.println(ans);

        ans = longestSubarrayWithSumKOptimalApproach2(numbers, k);
        System.out.println(ans);
    }
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    ans = Math.max(j - i + 1, ans);

                }

            }

        }
        return ans;
    }
// Optimal Approach TC : O(n) SC : O(n)
    public static int longestSubarrayWithSumKOptimalApproach(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum - k == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;

    }
    // Optimal Approach 2 (Only for non-negative numbers) TC : O(2*n) SC : O(1)
    public static int longestSubarrayWithSumKOptimalApproach2(int[] arr, int k) {
        int n = arr.length;
        int maxlen = 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left++];
            }

            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
            if (right < n)
                sum += arr[right];
        }
        return maxlen;
    }

}
