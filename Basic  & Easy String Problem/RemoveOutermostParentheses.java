public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int level = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (level > 0)
                    ans.append(ch);
                level++;
            } else if (ch == ')') {
                level--;
                if (level > 0)
                    ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        String ans = removeOuterParentheses(s);
        System.out.println(ans);
    }

}
