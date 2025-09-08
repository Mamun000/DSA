import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfArray {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 2, 3, 4, 4, 5 };

        unionOfArray(arr1, arr2);

        unionOfArrayOptimalApproach(arr1, arr2);

    }
    // Brute Force Approach TC : O((n + m) log(n + m)) SC : O(n + m)

    public static void unionOfArray(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : arr1) {
            set.add(x);
        }

        for (int x : arr2) {
            set.add(x);
        }
        System.out.print("Brute Force Approach: " + set);
    }

    // Optimal Approach TC : O(n + m) SC : O(1) If Space of union ArrayList is not
    // considered

    public static void unionOfArrayOptimalApproach(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;

        ArrayList<Integer> Union = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {

                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i]) {
                    Union.add(arr1[i]);

                }
                i++;
            } else {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j]) {
                    Union.add(arr2[j]);

                }
                j++;
            }

        }

        while (i < n) {

            if (Union.get(Union.size() - 1) != arr1[i]) {
                Union.add(arr1[i]);

            }
            i++;

        }
        while (j < m) {
            if (Union.get(Union.size() - 1) != arr2[j]) {
                Union.add(arr2[j]);

            }
            j++;
        }

        System.out.print("\nOptimal Approach : ");
        for (int x : Union) {
            System.out.print(x + " ");
        }
    }

}
