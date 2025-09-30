public class SearchInsertPosition {
    public static int searchInsertPosition(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
            if (arr[i] > x) {
                return i;
            }
        }
        return -1;
    }

    public static int searchInsertPositionOptimalApproach(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7 };
        int x = 6;
        int arr2[] = { 1, 2, 4, 7 };
        int x2 = 2;
        System.out.println(searchInsertPosition(arr, x));
        System.out.println(searchInsertPositionOptimalApproach(arr2, x2));
    }

}
