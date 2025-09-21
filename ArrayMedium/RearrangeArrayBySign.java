public class RearrangeArrayBySign {
    // Brute Force Approach TC : O(n) SC : O(n)
    public static void rearrangeArrayBySign(int[] arr) {
        int a1[] = new int[arr.length / 2];
        int a2[] = new int[arr.length / 2];
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                a1[c1++] = arr[i];
            } else if (arr[i] < 0) {
                a2[c2++] = arr[i];
            }
        }
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a1[count++];
            arr[++i] = a2[count2++];
        }

    }

    // Optimal Approach TC : O(n) SC : O(n)
    public static int[] rearrangeArrayBySignOptimalApproach(int[] nums) {
        int ans[] = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg += 2;
            } else {
                ans[pos] = nums[i];
                pos += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, -4, -5 };
        int nums2[] = { 3, 1, -2, -5, 2, -4 };
        rearrangeArrayBySign(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
        int ans[] = rearrangeArrayBySignOptimalApproach(nums2);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
