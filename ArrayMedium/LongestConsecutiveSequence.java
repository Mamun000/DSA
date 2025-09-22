import java.util.*;

public class LongestConsecutiveSequence {
    // Brute Force Approach TC : O(nlogn) SC : O(1)
    public static int longestConsecutiveSequence(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1; // Reset count for new sequence
            }
        }
        max = Math.max(count, max);
        return max;

    }

    // Optimal Approach TC : O(n) SC : O(n)
    public static int longestConsecutiveSequenceOptimalApproach(int[] arr) {
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int count = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 8, 5, 7, 6 };
        System.out.println("The longest consecutive sequence is " + longestConsecutiveSequence(nums));
        int[] a = { 100, 200, 1, 2, 3, 4 };
        int ans = longestConsecutiveSequenceOptimalApproach(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}