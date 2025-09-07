public class CheckArraySorted {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 6, 5 };

		checkSortedArray(numbers);

		checkSortedArrayOptimalApproach(numbers);
	}

	// Brute Force Approach TC: O(n^2) SC: O(1)
	public static void checkSortedArray(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
					break;
				}
			}
		}
		if (count == 0) {
			System.out.println("Sorted");
		} else {
			System.out.println("Not Sorted");
		}

	}

	// Optimal Approach TC: O(n) SC: O(1)

	public static void checkSortedArrayOptimalApproach(int[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				count++;
				break;
			}
		}

		if (count == 0) {
			System.out.println("Sorted");
		} else {
			System.out.println("Not Sorted");
		}
	}
}
