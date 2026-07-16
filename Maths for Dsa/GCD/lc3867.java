import java.util.*;
public class lc3867 {
    
    private static int  gcd(int a , int b){
        while(b != 0){
            int temp =  a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public  static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixsum = new int[n];
        int max =0;
        for(int i =0 ; i < n; i++){
           max = Math.max(max , nums[i]);
           prefixsum[i] = gcd(nums[i] , max);


        }
        Arrays.sort(prefixsum);
        
        long ans = 0;
        int left = 0;
        int right = n-1;

        while(left < right){
            ans+= gcd(prefixsum[left] , prefixsum[right]);
            left++;
            right--;
        }
    return ans;

}
    public static void main(String[] args) {

        int[] arr = {3,6,2,8};
        long  ans = gcdSum(arr);

        System.out.println();
        System.out.println( ans);
    }

}
