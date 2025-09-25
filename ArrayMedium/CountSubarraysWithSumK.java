import java.util.*;

public class CountSubarraysWithSumK {
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    // Optimal Approach TC : O(n) SC : O(n)
    public static int findAllSubarraysWithGivenSumOptimalApproach(int[] arr, int k) {
        int n = arr.length;
        int sum = 0, cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int remove = sum - k;

            cnt += map.getOrDefault(remove, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
        int cnt2 = findAllSubarraysWithGivenSumOptimalApproach(arr, k);
        System.out.println("The number of subarrays using optimal approach is: " + cnt2);
    }
}
