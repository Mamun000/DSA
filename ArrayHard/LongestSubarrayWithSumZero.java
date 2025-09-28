import java.util.HashMap;

public class LongestSubarrayWithSumZero {
    //Brute Force Approach TC : O(n^2) SC : O(1)
    public static int longestSubArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    //Optimal Approach TC : O(n) SC : O(n)
    public static int longestSubArrayOptimalApproach(int[] arr) {
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (ans.get(sum) != null) {
                    max = Math.max(max, i - ans.get(sum));
                } else {
                    ans.put(sum, i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(longestSubArray(a));
        System.out.println(longestSubArrayOptimalApproach(a));
    }

}
