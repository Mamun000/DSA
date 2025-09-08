public class FindMissingNumber {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 4, 5 };
        int N = numbers.length;

        int ans = findMissingNumber(numbers, N);
        System.out.println(ans);
        int ans2 = findMissingNumberOptimalApproach1(numbers, N + 1);
        System.out.println(ans2);
        int ans3 = findMissingNumberOptimalApproach2(numbers, N);
        System.out.println(ans3);
    }
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static int findMissingNumber(int[] a, int N) {
        for (int i = 1; i <= N; i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (a[j] == i) {
                    flag = 1;
                }
            }

            if (flag == 0)
                return i;
        }
        return -1;
    }
    // Optimal Approach 1 TC : O(n) SC : O(1)

    public static int findMissingNumberOptimalApproach1(int[] arr, int n) {
        int total = (n * (n + 1)) / 2;
        int sum = 0;

        for (int x : arr) {
            sum += x;
        }
        return total - sum;

    }
    // Optimal Approach 2 TC : O(n) SC : O(1) only works when numbers are from 1 to N and Sorted
    public static int findMissingNumberOptimalApproach2(int[] a, int N) {
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ N;
        return (xor1 ^ xor2);
    }

}
