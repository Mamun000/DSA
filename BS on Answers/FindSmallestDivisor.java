public class FindSmallestDivisor {
    //Brute Force Approach TC:O(N*max(arr)) SC:O(1)
    public static int findSmallestDivisor(int arr[], int limit) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        for (int i = 1; i <= max; i++) {
            int ans = 0;
            for (int j = 0; j < arr.length; j++) {
                ans += Math.ceil((double) (arr[j]) / (double) (i));
            }
            if (ans <= limit)
                return i;
        }
        return -1;
    }
    //Optimal Approach TC:O(N*log(max(arr))) SC:O(1)
    public static int findSmallestDivisorOptimalApproach(int arr[], int limit) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int low = 1, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int limit = 8;
        System.out.println(findSmallestDivisor(arr, limit));
        System.out.println(findSmallestDivisorOptimalApproach(arr, limit));
    }

    public static int sumByD(int[] arr, int div) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) (arr[i]) / (double) (div));
        }
        return sum;
    }

}
