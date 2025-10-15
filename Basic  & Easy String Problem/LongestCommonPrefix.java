import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();
        String first = arr[0];
        String last = arr[arr.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i))
                return ans.toString();
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] input = { "interview", "internet", "internal", "interval" };
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(input));
    }

}
