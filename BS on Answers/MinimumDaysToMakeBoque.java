public class MinimumDaysToMakeBoque {
    //Brute Force Approach TC:O(N*max(arr)) SC:O(1)
    public static int minimumDaysToBoquets(int arr[], int m, int k) {
        int n = arr.length;
        if (m * k > n)
            return -1;
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        for (int i = min; i <= max; i++) {
            if (possible(arr, i, m, k)) {
                return i;
            }
        }
        return -1;
    }
    //Optimal Approach TC:O(N*log(max(arr))) SC:O(1)
    public static int minimumDaysToBoquetsOptimalApproach(int arr[], int m, int k) {
        int n = arr.length;
        if (m * k > n)
            return -1;
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2, k = 3;
        System.out.println(minimumDaysToBoquets(arr, m, k));
        System.out.println(minimumDaysToBoquetsOptimalApproach(arr, m, k));
    }

    public static boolean possible(int arr[], int day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int boquet = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                boquet += count / k;
                count = 0;
            }
        }
        boquet += count / k;
        return boquet >= m;

    }

}
