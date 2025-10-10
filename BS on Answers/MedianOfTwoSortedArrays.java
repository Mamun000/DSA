import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static double medianOfSortedArrays(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> arr3 = new ArrayList<>();

        int i = 0, j = 0;
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

        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) arr3.get(n / 2);
        }
        double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
        return median;

    }

    public static double medianOfSortedArraysBetterApproach(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;

        int index2 = n / 2;
        int index1 = index2 - 1;
        int count = 0;

        int index1Element = -1, index2Element = -1;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (count == index1)
                    index1Element = arr1[i];
                if (count == index2)
                    index2Element = arr1[i];
                count++;
                i++;

            } else {
                if (count == index1)
                    index1Element = arr2[j];
                if (count == index2)
                    index2Element = arr2[j];
                count++;
                j++;
            }
        }

        while (i < n1) {
            if (count == index1)
                index1Element = arr1[i];
            if (count == index2)
                index2Element = arr1[i];
            count++;
            i++;
        }

        while (j < n2) {
            if (count == index1)
                index1Element = arr2[j];
            if (count == index2)
                index2Element = arr2[j];
            count++;
            j++;
        }

        if (n % 2 == 1) {
            return (double) index2Element;
        }

        return (double) ((double) (index1Element + index2Element)) / 2.0;

    }

    public static double medianOfSortedArraysOptimalApproach(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        // if n1 is bigger swap the arrays:
        if (n1 > n2)
            return medianOfSortedArraysOptimalApproach(b, a);

        int n = n1 + n2; // total length
        int left = (n1 + n2 + 1) / 2; // length of left half
        // apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            // calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0; // dummy statement
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2 };
        int arr2[] = { 3, 4 };
        System.out.println(medianOfSortedArrays(arr1, arr2));
        System.out.println(medianOfSortedArraysBetterApproach(arr1, arr2));
        System.out.println(medianOfSortedArraysOptimalApproach(arr1, arr2));

    }

}
