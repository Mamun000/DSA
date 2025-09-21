public class StockBuyAndSell {
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int maxProfit(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[j] - arr[i];
                max = Math.max(max, sum);

            }
        }
        return max;
    }
    // Optimal Approach TC : O(n) SC : O(1)
    public static int maxProfitOptimalApproach(int[] arr) {
        int maxPro = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - min);

        }
        return maxPro;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 1, 5, 3, 6, 4 };
        int ans = maxProfit(nums);
        System.out.println("Brute Force Approach : " + ans);

        int nums2[] = { 7, 6, 4, 3, 1 };
        ans = maxProfitOptimalApproach(nums);
        System.out.println("Optimal Approach : " + ans);
    }

}
