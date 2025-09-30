public class LastOccurrence {
    public static int lastOccurence(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int lastOccurenceOptimalApproach(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = { 3, 4, 13, 13, 13, 20, 40 };
        int x = 13;
        System.out.println(lastOccurence(ans, x));
        System.out.println(lastOccurenceOptimalApproach(ans, x));
    }

}
