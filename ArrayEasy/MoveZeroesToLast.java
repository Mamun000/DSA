public class MoveZeroesToLast {
    public static void main(String[] args) {
        int[] numbers = { 1, 0, 2, 3, 0, 4, 0, 1 };

        moveZeroesToLast(numbers);

        moveZeroesToLastOptimalApproach(numbers);

        System.out.println();
        System.out.print("After Optimal Approach: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    // Naive Approach TC: O(n) SC: O(n)
    public static void moveZeroesToLast(int[] arr) {

        int[] temp = new int[arr.length];
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[x++] = arr[i];

            }

        }
        for (int i = x; i < arr.length; i++) {
            temp[i] = 0;
        }
        System.out.print("After Naive Approach: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    // Optimal Approach TC: O(n) SC: O(1)
    public static void moveZeroesToLastOptimalApproach(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

}
