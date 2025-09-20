
public class TwoSum {
    
    // Brute Force Approach TC : O(n^2) SC : O(1)
    public  static int[] findTwoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
 // Optimal Approach TC : O(n) SC : O(1)
    public static int[] findTwoSumOptimalApproach(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                return new int[] { i, j };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 7, 11, 15 };
        int numberss[] = { 2, 7, 11, 15 };
        int target =13;
        int ans[] = findTwoSum(numbers, target);
        System.out.println("Brute Force Approach : ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println("\nOptimal Approach : ");
        ans = findTwoSumOptimalApproach(numberss, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
