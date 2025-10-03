public class NthRoot {
    public static int helper(int n, int m) {
        int ans = 1;
        for (int i = 1; i <= m; i++) {
            ans *= n;
        }
        return ans;
    }

    public static int nthRoot(int n, int m) {
        for (int i = 1; i <= m; i++) {
            int val = helper(i, n);
            if (val == m)
                return i;
            else if (val > m)
                break;
        }
        return -1;
    }

    public static int helper2(int mid, int n, int m) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static int nthRootOptimalApproach(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = helper2(mid, n, m);
            if (val == 1) {
                return mid;
            } else if (val == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(3, 8));
        System.out.println(nthRootOptimalApproach(3, 27));
    }

}
