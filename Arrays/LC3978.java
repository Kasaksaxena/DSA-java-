import java.util.*;

public class LC3978{

    static boolean isUniqueMiddleelt(int[] nums){
        int n = nums.length;
        int mid = n/2;
        int count =0;

        for(int num : nums){
            if(num == nums[mid]){
                count++;
                   
            }  
        }
    return count ==1 ;
}

    public static void main(String[] args){
        int[] nums ={1,2,2};
        int[] arr ={1,2,3};

        System.out.println(isUniqueMiddleelt(nums));
        System.out.println(isUniqueMiddleelt(arr));


    }
}
