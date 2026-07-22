import java.util.Arrays;

public class FibonacciMemoization {

    static int[] dp;

    static int fib(int n){

        if( n <= 1){
            return n;
        }

        //  already calc 
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }

        public static void main(String[] args) {

        int n = 6;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(fib(n));
    }

    
}
// Time
// O(n)
//Space
//O(n) + O(n)