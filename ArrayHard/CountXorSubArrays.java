import java.util.*;

public class CountXorSubArrays {
    //Brute Force Approach TC : O(n^2) SC : O(1)
    public static int countXorSubArrays(int arr[], int k) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }

        }
        return count;
    }
    //Optimal Approach TC : O(n) SC : O(n)
    public static int countXorSubArraysOptimalApproach(int arr[], int k) {
        int count = 0;
        int n = arr.length;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(xor, 1);
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            int x = xor ^ k;

            if (map.containsKey(x)) {
                count += map.get(x);
            }

            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println(countXorSubArrays(arr, k));
        System.out.println(countXorSubArraysOptimalApproach(arr, k));
    }
}