import java.util.*;

public class HouseRobber {

     static int[] dp;

     static int Lc198(int[] nums){

        int n = nums.length;
        dp = new int[n];

        Arrays.fill(dp , -1);

     return solve(n -1 , nums);
     }

     static int solve(int i , int[] nums){

        // base 1 cond
        if( i == 0){
            return nums[0];
        }

        // base 2 cond

        if(i < 0){
            return 0;
        }

        // already calc

        if( dp[i] != -1){
            return dp[i];
        }


        int rob = nums[i] + solve(i-2, nums);
        int skip = solve(i-1 , nums);

        dp[i] = Math.max(rob , skip);

        return dp[i];
     }


     public static void main(String[] args){

        int[] nums ={2,7,9,3,1};

        int ans = Lc198(nums);
        System.out.println(ans);
     }
    
}

//Time = O(n)

//Space = O(n)
