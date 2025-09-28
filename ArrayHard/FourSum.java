import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    //Brute Force Approach TC : O(n^4) SC : O(m) m is no of quadruplets
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) arr[i] + arr[j];
                        sum += arr[k];
                        sum += arr[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    //Better Approach TC : O(n^3) SC : O(m+n) m is no of quadruplets n is size of hashset
    public static List<List<Integer>> fourSumBetterApproach(int arr[], int target) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int four = target - (arr[i] + arr[j] + arr[k]);
                    if (hashset.contains(four)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], four);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                    hashset.add(arr[k]);

                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    //Optimal Approach TC : O(n^3) SC : O(m) m is no of quadruplets
    public static List<List<Integer>> fourSumOptimalApproach(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    if (arr[i] + arr[j] + arr[k] + arr[l] > target) {
                        l--;
                    } else if (arr[i] + arr[j] + arr[k] + arr[l] < target) {
                        k++;
                    } else {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        temp.sort(null);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.print("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>> ans2 = fourSumBetterApproach(nums, target);
        System.out.print("The quadruplets are: ");
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        List<List<Integer>> ans3 = fourSumOptimalApproach(nums, target);
        System.out.print("The quadruplets are: ");
        for (List<Integer> it : ans3) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

}
