import java.util.*;
public class LC383 {

        public static boolean canConstruct(String ransomNote, String magazine) {

            int[] freq = new int[26];

            for(char c : magazine.toCharArray()){
                freq[c - 'a']++;
            }

            for(char c : ransomNote.toCharArray()){
                if(freq[c -'a'] == 0){
                    return false;
                }
                freq[c - 'a']--;
            }
        return true;



        }

        public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
    
}
