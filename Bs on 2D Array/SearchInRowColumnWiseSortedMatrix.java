public class SearchInRowColumnWiseSortedMatrix {
    // Brute Force Approach TC: O(N*M) SC: O(1)
    public static boolean searchElement(int[][] matrix, int target) {

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
    public static boolean searchElementBetterApproach(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;

    }
    // Optimal Approach TC: O(N+M) SC: O(1)
    public static boolean searchElementOptimalApproach(int[][]matrix,int target){
        int n=matrix.length;
        int m=matrix[0].length;

        int row=0, col=m-1;

        while(row<n && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][]matrix = {{1, 4, 7, 11, 15},
                         {2, 5, 8, 12, 19},
                         {3, 6, 9, 16, 22}, 
                         {10, 13, 14, 17, 24},
                         {18, 21, 23, 26, 30}};
    boolean result = searchElement(matrix, 8);
    System.out.println(result ? "true" : "false"); 
    boolean result2 = searchElementBetterApproach(matrix, 25);
    System.out.println(result2 ? "true" : "false");
    boolean result3 = searchElementOptimalApproach(matrix, 30);
    System.out.println(result3 ? "true" : "false"); 
    }
    
}
