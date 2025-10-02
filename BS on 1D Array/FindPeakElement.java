public class FindPeakElement {
    // Brute Force Approach Time Complexity O(n) Space Complexity O(1)
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return i;
            }
        }
        if (arr[0] > arr[n - 1]) {
            return 0;
        } else {
            return n - 1;
        }

    }

    // Optimal Approach Time Complexity O(log n) Space Complexity O(1)
    public static int findPeakElementOptimalApproach(int[] arr) {

        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 2] < arr[n - 1])
            return n - 1;

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        System.out.println(findPeakElement(arr));
        System.out.println(findPeakElementOptimalApproach(arr));
    }
}
