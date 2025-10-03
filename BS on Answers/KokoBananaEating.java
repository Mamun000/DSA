
public class KokoBananaEating {
    public static int kokoEatingBananas(int[] arr, int h) {
        int max = findMax(arr);
        for (int i = 1; i <= max; i++) {
            int requireTime = calculateTotalHour(arr, i);
            if (requireTime <= h) {
                return i;
            }

        }
        return max;
    }

    public static int kokoEatingBananasOptimalApproach(int arr[], int h) {
        int low = 0, high = findMax(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            int ans = calculateTotalHour(arr, mid);
            if (ans <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 15, 6, 3 };
        int n = 4;
        int h = 8;
        System.out.println(kokoEatingBananas(arr, h));
        System.out.println(kokoEatingBananasOptimalApproach(arr, h));

    }

    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int calculateTotalHour(int arr[], int h) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += Math.ceil((double) (arr[i]) / (double) (h));
        }
        return total;
    }

}
