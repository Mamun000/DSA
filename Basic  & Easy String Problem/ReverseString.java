import java.util.Stack;

public class ReverseString {
    public static String reverseString(String s) {
        s += " ";
        String str = "";
        Stack<String> st = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                st.push(str);
                str = "";
            } else {
                str += s.charAt(i);
            }
        }
        String ans = "";
        while (st.size() != 1) {
            ans += st.peek() + " ";
            st.pop();
        }
        ans += st.peek();

        return (ans);

    }

    public static String reverseStringOptimalApproach(String s) {
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch;
            } else if (ch == ' ') {
                if (!ans.equals("")) {
                    ans = temp + " " + ans;
                } else {
                    ans = temp;
                }
                temp = "";
            }
            left++;
        }

        // If not empty string then add to the result(Last word is added)
        if (!temp.equals("")) {
            if (!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String ans = reverseString(s);
        System.out.println(ans);
        System.out.println(reverseStringOptimalApproach(s));

    }

}
