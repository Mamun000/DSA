public class CheckRotationStringContains {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rotatedStringOptimalApproach(String s, String goal) {
        if (s.length() != goal.length()) {
            // Return false if lengths don't match
            return false;
        }
        String ans = s + goal;

        return ans.contains(goal);
    }

    public static void main(String[] args) {
        String s = "rotation";
        String goal = "tionrota";
        System.out.println(rotateString(s, goal));
        System.out.println(rotatedStringOptimalApproach(s, goal));
    }

}
