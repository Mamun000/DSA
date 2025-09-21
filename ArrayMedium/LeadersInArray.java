public class LeadersInArray {
    public static void leadersInArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + " ");
            }

        }
        System.out.print(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        int nums[] = { 10, 22, 12, 3, 0, 6 };
        leadersInArray(nums);
    }

}
