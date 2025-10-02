public class SearchInRotatedArrayI {
    public static int searchInRotatedSortedArray(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static int searchInRotatedSortedArrayOptimalApproach(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && arr[mid] >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && arr[high] >= k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int k = 0;
        System.out.println(searchInRotatedSortedArray(arr, k));
        System.out.println(searchInRotatedSortedArrayOptimalApproach(arr, k));
    }

}
