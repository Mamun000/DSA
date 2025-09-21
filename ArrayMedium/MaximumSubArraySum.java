public class MaximumSubArraySum {
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int maximumSubArraySum(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);

            }
        }

        return maxSum;
    }

    // Optimal Approach TC : O(n) SC : O(1) Kadane's Algorithm
    public static int maximumSubArraySumOptimalApproach(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int ans = maximumSubArraySum(nums);
        System.out.println("Brute Force Approach :" + ans);

        ans = maximumSubArraySumOptimalApproach(nums);
        System.out.println("Optimal Approach :" + ans);
    }

}
