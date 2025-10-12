public class SearchIn2DArray {
    // Brute Force Approach TC: O(N*M) SC: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    // Better Approach TC: O(N*logM) SC: O(1)
    public static boolean searchMatrixBetterApproach(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;

    }
    // Optimal Approach TC: O(log(N*M)) SC: O(1)

    public static boolean searchMatrixOptimalApproach(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        boolean result = searchMatrix(matrix, 8);
        System.out.println(result ? "true" : "false");
        boolean result2 = searchMatrixBetterApproach(matrix, 8);
        System.out.println(result2 ? "true" : "false");
        boolean result3 = searchMatrixOptimalApproach(matrix, 8);
        System.out.println(result3 ? "true" : "false");

    }

}
