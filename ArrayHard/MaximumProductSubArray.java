public class MaximumProductSubArray {
    // Brute Force Approach - O(n^2) time complexity and O(1) space complexity
    public static int maximumProductSubArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int pro = arr[i];
            for (int j = i + 1; j < n; j++) {
                pro = pro * arr[j];
                max = Math.max(max, pro);
            }

        }
        return max;
    }
    // Optimal Approach - O(n) time complexity and O(1) space complexity
    public static int maximumProductSubArrayOptimalApproach(int[] arr) {
        int n = arr.length;
        int pre = 1, suf = 1;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;

            pre *= arr[i];
            suf *= arr[n - i - 1];
            ans = Math.max(pre, suf);

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 0 };
        System.out.println(maximumProductSubArray(arr));
        System.out.println(maximumProductSubArrayOptimalApproach(arr));
    }

}
