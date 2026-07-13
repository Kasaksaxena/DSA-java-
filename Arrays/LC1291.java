import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1291 {

        public static List<Integer> sequentialDigits(int low, int high) {

            List<Integer> ans = new ArrayList<>();

            for(int start =1 ; start<=9 ; start++){
                int num = start;
                for(int next = start+ 1; next <= 9; next++){
                    num = num * 10 + next ;

                    if(num > high){
                        break;
                    }
                    if(num >= low){
                        ans.add(num);
                    }

                    
                }

            }
        Collections.sort(ans);
        return ans;
        }

    public static void main(String[] args){
        int low = 1000;
        int high = 3000;

        List<Integer> ans =sequentialDigits(low , high);
        System.out.println(ans);
    }

    
}
