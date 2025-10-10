import java.util.ArrayList;

public class KthElement {
    public static int kthElement(int arr1[], int arr2[], int k) {
        ArrayList<Integer> arr3 = new ArrayList<>();

        int i = 0, j = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3.add(arr1[i++]);
            } else {
                arr3.add(arr2[j++]);
            }
        }

        while (i < n1) {
            arr3.add(arr1[i++]);
        }
        while (j < n2) {
            arr3.add(arr2[j++]);
        }
        return arr3.get(k - 1);
    }

    public static int kthElementBetterApproach(int arr1[], int arr2[], int k) {
        int ele = -1;
        int count = 0;

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (count == k - 1)
                    ele = arr1[i];
                count++;
                i++;
            } else {
                if (count == k - 1)
                    ele = arr2[j];
                count++;
                j++;
            }
        }
        return ele;
    }

    public static int kthElementOptimalApproach(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;
        if (m > n)
            return kthElementOptimalApproach(b, a, k);

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < m)
                r1 = a[mid1];
            if (mid2 < n)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0; // dummy statement
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };
        System.out.println(kthElement(arr1, arr2, 5));
        System.out.println(kthElementBetterApproach(arr1, arr2, 5));
        System.out.println(kthElementOptimalApproach(arr1, arr2, 5));
    }

}
