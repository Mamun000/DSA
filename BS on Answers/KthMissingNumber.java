public class KthMissingNumber {
    // Brute Force Approach TC:O(N) SC:O(1)
    public static int kthMissingNumber(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    // Optimal Approach TC:O(logN) SC:O(1)
    public static int kthMissingNumberOptimalApproach(int arr[], int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 10 };
        int k = 4;
        System.out.println(kthMissingNumber(arr, k));
        System.out.println(kthMissingNumberOptimalApproach(arr, k));
    }

}
