public class LeftRotateArrayByOne {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };

        leftRotateByOne(numbers);

        leftRotateByOneOptimalApproach(numbers);
    }

    public static void leftRotateByOne(int[] arr) {
        int[] temp = new int[arr.length];
        int x = arr[0];

        for (int i = 1; i < arr.length; i++) {
            temp[i - 1] = arr[i];
        }
        temp[arr.length - 1] = x;
        System.out.print("Brute Force Approach: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();

    }

    public static void leftRotateByOneOptimalApproach(int[] arr) {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = x;

        System.out.print("Optimal Approach: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
