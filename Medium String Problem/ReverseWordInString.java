import java.util.ArrayList;
import java.util.List;

public class ReverseWordInString {
    public static String reverseWords(String s) {
        int n = s.length(); // Length of string

        // List to store the words present in string
        List<String> words = new ArrayList<>();

        // Pointers to mark the start and end of a word
        int start, end;

        int i = 0;
        while (i < n) {

            // Finding the first character of a word (if any)
            while (i < n && s.charAt(i) == ' ')
                i++;

            // If no word is found, break
            if (i >= n)
                break;

            start = i; // Storing the index of first character of word

            // Finding the last character of the word
            while (i < n && s.charAt(i) != ' ')
                i++;

            end = i - 1; // Storing the index of last character of word

            // Add the found word to the list of words
            String wordFound = s.substring(start, end + 1);
            words.add(wordFound);
        }

        StringBuilder ans = new StringBuilder();

        // Adding all the words to result in the reverse order
        for (int j = words.size() - 1; j >= 0; j--) {
            ans.append(words.get(j));

            // Adding spaces in between words
            if (j != 0)
                ans.append(' ');
        }

        return ans.toString(); // Return the stored result
    }

    public static void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static String reverseWordsOptimalApproach(String s) {
        int n = s.length();

        // Reverse the entire string
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);

        int i = 0, j = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && sb.charAt(j) == ' ')
                j++;
            if (j == n)
                break;

            int start = i;

            // Copy the word characters forward
            while (j < n && sb.charAt(j) != ' ') {
                if (i < sb.length()) {
                    sb.setCharAt(i++, sb.charAt(j++));
                } else {
                    sb.append(sb.charAt(j++));
                    i++;
                }
            }

            int end = i - 1;

            // Reverse the current word using start and end
            reverseString(sb, start, end);

            // Add a space after the word if it's not the last word
            if (j < n) {
                if (i < sb.length()) {
                    sb.setCharAt(i++, ' ');
                } else {
                    sb.append(' ');
                    i++;
                }
            }
        }

        // Remove trailing space if present
        if (i > 0 && sb.charAt(i - 1) == ' ')
            i--;

        return sb.substring(0, i);
    }

    public static void main(String[] args) {
        String s = " amazing coding skills ";
        String s2 = "  hello world  ";
        String ans = reverseWords(s);
        String ans2 = reverseWords(s2);
        System.out.println("After reversing every word: " + ans);
        System.out.println("After reversing every word: " + ans2);
    }

}
