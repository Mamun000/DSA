public class FIndSqrt {
    public static int findSqrt(int num) {
        for (int i = 1; i < num; i++) {
            if (i * i == num) {
                return i;
            } else if (i * i > num) {
                return i - 1;
            }
        }
        return -1;
    }

    public static int findSqrtOptimalApproachOne(int num) {
        return (int) Math.sqrt(num);
    }

    public static int findSqrtOptimalApproachTwo(int num) {
        int low = 1, high = num;

        while (low <= high) {
            int mid = (low + high) / 2;
            int val = mid * mid;

            if (val <= num) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(28));
        System.out.println(findSqrtOptimalApproachOne(36));
        System.out.println(findSqrtOptimalApproachTwo(49));
    }

}
