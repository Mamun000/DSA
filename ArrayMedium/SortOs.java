
public class SortOs {

    // Bubble Sort TC : O(n^2) SC : O(1)
    public static void sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // Counting Sort TC : O(n) SC : O(1)
    public static void sortArrayOptimalApproach(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else if (arr[i] == 2) {
                count2++;
            }
        }

        // Fill the array in a single pass
        for (int i = 0; i < n; i++) {
            if (count0 > 0) {
                arr[i] = 0;
                count0--;
            } else if (count1 > 0) {
                arr[i] = 1;
                count1--;
            } else {
                arr[i] = 2;
                count2--;
            }
        }
    }

    // Dutch National Flag Algorithm TC : O(n) SC : O(1)
    public static void sortArrayBetterApproach(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        int nums2[] = { 2, 0, 2, 1, 1, 0 };
        int nums3[] = { 2, 0, 2, 1, 1, 0 };
        sortArray(nums);

        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
        sortArrayOptimalApproach(nums2);
        for (int x : nums) {
            System.out.print(x + " ");
        }

        System.out.println();
        sortArrayBetterApproach(nums3);
        for (int x : nums) {
            System.out.print(x + " ");
        }

    }

}
