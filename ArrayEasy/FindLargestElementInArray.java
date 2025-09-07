import java.util.*;

public class FindLargestElementInArray {
    public static void main(String[] args) {
        int[] numbers = { 3, 5, 7, 2, 8 };
        findLargestElement(numbers);
        findLargestElementBruteForce(numbers);
    }

    // Brute Force Approach TC: O(n log n) SC: O(1)
    public static void findLargestElementBruteForce(int[] arr) {
        Arrays.sort(arr);
        System.out.println("The largest element in the array is: " + arr[arr.length - 1]);
    }

    // Recursive approach TC: O(n) SC: O(1)
    public static void findLargestElement(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("The largest element in the array is: " + largest);
    }

}
