public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));          // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon   ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(lengthOfLastWord("a"));                    // 1
        System.out.println(lengthOfLastWord("day"));                  // 3

    }
}