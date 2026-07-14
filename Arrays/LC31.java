import java.util.*;

public class LC31 {

    static void swap(int[] nums , int start , int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    static void reverse(int[] nums , int start , int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

     public static void nextPermutation(int[] nums) {

        int pivot = nums.length -2;

        while(pivot >= 0 && nums[pivot] >= nums[pivot + 1]){
            pivot--;
        }
        if(pivot >= 0){
            int j = nums.length-1;
            while(nums[j] <= nums[pivot]){
                j--;

            }
            swap(nums , pivot ,j);
        }

    reverse(nums ,pivot + 1 , nums.length-1);

     }
    
    public static void main(String[] args){
        int[] arr1 ={1,2,3};
        int[] arr2 ={2,3,5,6,4};
        nextPermutation(arr1);
        nextPermutation(arr2);


        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    
}
