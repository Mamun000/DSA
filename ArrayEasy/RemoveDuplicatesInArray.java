import java.util.HashSet;

public class RemoveDuplicatesInArray {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 2, 3, 3, 4 };
		removeDuplicates(numbers);

		removeDuplicatesOptimalApproach(numbers);

	}

	// Brute Force Approach TC: O(n) SC: O(n)
	public static void removeDuplicates(int[] arr) {

		HashSet<Integer> ans = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			ans.add(arr[i]);
		}
		System.out.println(ans.size());

	}

	// Optimal Approach TC: O(n) SC: O(1)
	public static void removeDuplicatesOptimalApproach(int[] arr) {
		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		System.out.println(i + 1);
	}

}
