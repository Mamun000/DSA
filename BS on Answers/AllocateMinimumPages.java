public class AllocateMinimumPages {
    // Brute Force Approach Time Complexity O(n*(sum(arr[])-max(arr[])+1)) Space
    // Complexity O(1)
    public static int allocateMinimumNumberOfPages(int arr[], int m) {
        int n = arr.length;
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        for (int i = low; i <= high; i++) {
            int x = checkIfPossible(arr, i);
            if (x == m) {
                return i;
            }

        }
        return -1;

    }
    // Optimal Approach Time Complexity O(n*log(sum(arr[])-max(arr[])+1)) Space
    // Complexity O(1)

    public static int allocateMinimumNumberOfPagesOptimalApproach(int arr[], int m) {
        int n = arr.length;
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkIfPossible(arr, mid) == m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int m = 2;
        System.out.println(allocateMinimumNumberOfPages(arr, m));
        System.out.println(allocateMinimumNumberOfPagesOptimalApproach(arr, m));
    }

    public static int checkIfPossible(int arr[], int pages) {
        int student = 1;
        int pagesHolding = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesHolding + arr[i] <= pages) {
                pagesHolding += arr[i];
            } else {
                pagesHolding = arr[i];
                student++;
            }
        }
        return student;
    }

}
