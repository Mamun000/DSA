public class RotateArrayByK {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 2;
        int n = numbers.length;

        rotateArrayByK(numbers, k, n);

        rotateArrayByKOptimalApproach(numbers, k, n);

        System.out.print("After Optimal Approach: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    // Naive Approach TC: O(n) SC: O(n)
    public static void rotateArrayByK(int[] arr, int k, int n) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[arr.length];
        int count = 0;
        for (int i = k; i < arr.length; i++) {
            temp[count++] = arr[i];
        }
        int x = 0;

        for (int i = count; i < arr.length; i++) {
            temp[count++] = arr[x++];
        }
        System.out.print("After Naive Approach: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }

    // Optimal Approach TC: O(n) SC: O(1)
    public static void rotateArrayByKOptimalApproach(int[] arr, int k, int n) {
        ReverseArray(arr, 0, k - 1);
        ReverseArray(arr, k, n - 1);
        ReverseArray(arr, 0, n - 1);
    }

    public static void ReverseArray(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
