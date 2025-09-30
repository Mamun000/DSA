public class LowerBound {
    public static int lowerBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        return -1;
    }

    public static int lowerBoundOptimalApproach(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3 };
        int x = 2;
        System.out.println(lowerBound(arr, x));
        System.out.println(lowerBoundOptimalApproach(arr, x));
    }

}
