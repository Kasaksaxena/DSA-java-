import java.util.*;

public class LC238{

        public static int[] productExceptSelf(int[] nums) {

            int n = nums.length;
            int[] suffix = new int[n];
            suffix[n-1] = nums[n-1];
            int[] prefix = new int[n];
            prefix[0] = nums[0];

            for(int i =1; i <n;i++){
                prefix[i] = prefix[i-1] * nums[i];
            }

            for(int  i = n-2 ; i >= 0;i--){
                suffix[i] = suffix[i+1]  * nums[i];
            }

            for(int i =0; i <n; i++){
                if(i == 0){
                    nums[i] = suffix[i+1];
                }else if(i == n-1){
                    nums[i] = prefix[i-1];
                }else{
                    nums[i] = prefix[i-1]  * suffix[i+1];
                }
            }
        return nums;
        }


            public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        int[] ans = productExceptSelf(nums);

        System.out.println("\nProduct Except Self:");
        System.out.println(Arrays.toString(ans));
    }

}