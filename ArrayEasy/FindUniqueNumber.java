import java.util.HashMap;
import java.util.Map;

public class FindUniqueNumber {
    public static void main(String[] args) {
        int numbers[] = { 4, 1, 2, 1, 2 };

        findUniqueNumber(numbers);

        findUniqueNumberBApproach(numbers);

        findUniqueNumberOptimalApproach(numbers);
    }
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public static void findUniqueNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
    // Better Approach TC : O(n) SC : O(n)
    public static void findUniqueNumberBApproach(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() == 1) {
                System.out.println(it.getKey());
                break;
            }
        }
    }
    // Optimal Approach TC : O(n) SC : O(1)
    public static void findUniqueNumberOptimalApproach(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        System.out.println(xor);
    }

}
