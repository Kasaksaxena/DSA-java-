import java.util.*;

public class ClimbingStairsMemoization {

    static int[] dp;

    static int climbStairs(int n) {

        // Base Case
        if (n <= 1) {
            return 1;
        }

        // Already Calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Store Answer
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int answer = climbStairs(n);

        System.out.println(answer);
    }
}