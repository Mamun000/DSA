public class CountOccurrence {
    public static int countOccurrence(int[] arr, int x) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        return count;
    }

    public static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                count = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    public static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                count = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    public static int countOccurrenceOptimalApproach(int[] arr, int x) {
        int a = lastOccurrence(arr, x);
        int b = firstOccurrence(arr, x);
        return a - b + 1;
    }

    public static void main(String[] args) {
        int ans[] = { 2, 2, 3, 3, 3, 3, 4 };
        int x = 3;
        System.out.println(countOccurrence(ans, x));
        System.out.println(countOccurrenceOptimalApproach(ans, x));
    }
}
