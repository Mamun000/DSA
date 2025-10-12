public class FindPeakElement {
    // Helper function to find the index of the row 
      // with the maximum element in a given column
      public static int maxElement(int[][] arr, int col) {
          int n = arr.length;
          int max = Integer.MIN_VALUE;
          int index = -1;
  
          // Iterate through each row to find the maximum element 
          // in the specified column
          for (int i = 0; i < n; i++) {
              if (arr[i][col] > max) {
                  max = arr[i][col];
                  index = i;
              }
          }
          return index;
      }
  
      // Function to find a peak element in the 2D matrix 
      // using binary search
      public static int[] findPeakGrid(int[][] arr) {
          int n = arr.length;
          int m = arr[0].length;
  
          int low = 0;
          int high = m - 1;
  
          // Perform binary search on columns
          while (low <= high) {
              int mid = (low + high) / 2;
  
              // Find the index of the row with the maximum element 
              // in the middle column
              int row = maxElement(arr, mid);
  
              // Determine left and right neighbors of middle element
              int left = mid - 1 >= 0 ? arr[row][mid - 1] : Integer.MIN_VALUE;
              int right = mid + 1 < m ? arr[row][mid + 1] : Integer.MIN_VALUE;
  
              // Check if the middle element is a peak
              if (arr[row][mid] > left && arr[row][mid] > right) {
                  return new int[]{row, mid};
              } else if (left > arr[row][mid]) {
                  high = mid - 1;
              } else {
                  low = mid + 1;
              }
          }
  
          // Return [-1, -1] if no peak element is found
          return new int[]{-1, -1};
      }
  
 
      public static void main(String[] args) {
          int[][] mat = {
              {4, 2, 5, 1, 4, 5},
              {2, 9, 3, 2, 3, 2},
              {1, 7, 6, 0, 1, 3},
              {3, 6, 2, 3, 7, 2}
          };
          int[] peak =findPeakGrid(mat);
  
          System.out.println("The row of the peak element is " + peak[0] +
                             " and the column of the peak element is " + peak[1]);
      }
    
}
