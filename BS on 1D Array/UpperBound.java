public class UpperBound {
    //Brute Force Approach - O(n) time complexity and O(1) space complexity
    public static int upperBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                return i;
            }
        }
        return -1;
    }
    //Optimal Approach - O(log n) time complexity and O(1) space complexity
    public static int upperBoundOptimalApproach(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] <= x) {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = { 3, 5, 8, 9, 15, 19 };
        int x = 9;
        System.out.println(upperBound(ans, x));
        System.out.println(upperBoundOptimalApproach(ans, x));
    }

}
