import java.util.*;

public class LC58 {

    public static int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        int count = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "Hello World   ";

        System.out.println(lengthOfLastWord(s));
    }
}