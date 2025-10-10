import java.util.Arrays;
public class AggressiveCows {
    // Brute Force Approach Time Complexity O(n log n + n * max) Space Complexity O(1)
    public static int aggressiveCows(int arr[], int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 1; i <= max; i++) {
            if (!checkIfPossible(arr, i, k)) {
                return i - 1;
            }
        }
        return -1;
    }
    // Optimal Approach Time Complexity O(n log n + n log(max)) Space Complexity O(1)
    public static int aggressiveCowsOptimalApproach(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (checkIfPossible(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    public static void main(String[] args) {
        int arr[] = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println(aggressiveCows(arr, k));
        System.out.println(aggressiveCowsOptimalApproach(arr, k));
    }

    public static boolean checkIfPossible(int arr[], int dis, int k) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dis) {
                count++;
                last = arr[i];
            }
            if (count >= k)
                return true;

        }
        return false;
    }

}
