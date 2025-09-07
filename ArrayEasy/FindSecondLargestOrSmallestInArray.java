import java.util.Arrays;

public class FindSecondLargestOrSmallestInArray {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 5, 8, 7 };

		findSecondLargestAndSmallest(numbers);

		findSecondLargestAndSmallestBetterApproach(numbers);

		findSecondLargestAndSmallestOptimalApproach(numbers);

	}

	// Brute Force Approach TC: O(nlogn) SC: O(1)
	public static void findSecondLargestAndSmallest(int[] arr) {
		Arrays.sort(arr);
		System.out.println("Second Largest Element using Brute Force Approach: " + arr[arr.length - 2]);
		System.out.println("Second Smallest Element using Brute Force Approach: " + arr[1]);
	}

	// Better Approach TC: O(n) SC: O(1)
	public static void findSecondLargestAndSmallestBetterApproach(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}

		int secondlargest = Integer.MIN_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > secondlargest && arr[i] != largest) {
				secondlargest = arr[i];
			}
			if (arr[i] < secondSmallest && arr[i] != smallest) {
				secondSmallest = arr[i];
			}
		}
		System.out.println("Second Largest Element using Better Approach: " + secondlargest);
		System.out.println("Second Smallest Element using Better Approach: " + secondSmallest);
	}

	// Optimal Approach TC: O(n) SC: O(1)
	public static void findSecondLargestAndSmallestOptimalApproach(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		int secondlargest = Integer.MIN_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			} else if (arr[i] < secondSmallest && arr[i] != smallest) {
				secondSmallest = arr[i];
			}

			if (arr[i] > largest) {
				secondlargest = largest;
				largest = arr[i];
			} else if (arr[i] < secondlargest && arr[i] != largest) {
				secondlargest = arr[i];
			}

		}
		System.out.println("Second Largest Element using Optimal Approach: " + secondlargest);
		System.out.println("Second Smallest Element using Optimal Approach: " + secondSmallest);
	}

}
