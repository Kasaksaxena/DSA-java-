import java.util.*;

public class LC771 {

    public static int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        // Store all jewels
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        // Count matching stones
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }
}