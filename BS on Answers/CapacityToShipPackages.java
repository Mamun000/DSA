public class CapacityToShipPackages {
    // Brute Force Approach TC:O(N*max(arr)) SC:O(1)
    public static int capacityToShipPackages(int arr[], int day) {
        int max = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max += arr[i];
            min = Math.max(min, arr[i]);
        }

        for (int i = min; i <= max; i++) {
            if (findDays(arr, i) <= day) {
                return i;
            }
        }
        return -1;
    }
    // Optimal Approach TC:O(N*log(max(arr))) SC:O(1)

    public static int capacityToShipPackagesOptimalApproach(int arr[], int day) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findDays(arr, mid) <= day) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int weights[] = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int day = 5;
        System.out.println(capacityToShipPackages(weights, day));
        System.out.println(capacityToShipPackagesOptimalApproach(weights, day));
    }

    public static int findDays(int[] arr, int cap) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > cap) {
                days++;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }
        return days;

    }

}
