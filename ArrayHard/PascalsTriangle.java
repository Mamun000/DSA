import java.util.*;

public class PascalsTriangle {
    //Variation 1 : Find the value at a given position in Pascal's Triangle
    // TC : O(r) SC : O(1)
    public static int pascalNumber(int row, int col) {
        int ans = 1;
        for (int i = 0; i < col; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);

        }
        return ans;

    }
    // Variation 2 : Print the nth row of Pascal's Triangle
    // TC : O(n) SC : O(1)
    public static void pascalNumberVariationTwo(int row) {
        int ans = 1;
        System.out.print(ans + " ");
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
    }
    // Variation 3 : Print the first n rows of Pascal's Triangle
    // TC : O(n^2) SC : O(n^2)

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(genarateRow(i));
        }
        return ans;
    }
    
    public static List<Integer> genarateRow(int n) {
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            ansRow.add((int) ans);

        }
        return ansRow;
    }

    public static void main(String[] args) {
        int row = 5, col = 3;
        System.out.println(pascalNumber(row - 1, col - 1));
        pascalNumberVariationTwo(row);
        System.out.println();
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

}
