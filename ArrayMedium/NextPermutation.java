public class NextPermutation {
    // If using C++ STL next_permutation function TC : O(n) SC : O(1)

    // Optimal Approach TC : O(n) SC : O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n - 1);
        } else {
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
            reverse(nums, index + 1, n - 1);
        }

    }

    // Function to reverse the array
    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] arr = { 1, 2, 3 };
        np.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
