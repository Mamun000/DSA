public class CountMaximunConsecutiveOne {
    public static void main(String[] args) {
        int[] numbers = { 1, 1, 0, 1, 1, 1 };

        countMaximunConsecutiveOne(numbers);

    }

    public static void countMaximunConsecutiveOne(int[] arr) {
        int count = 0;
        int maxi = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxi = Math.max(maxi, count);
        }
        System.out.print(maxi);
    }
}
