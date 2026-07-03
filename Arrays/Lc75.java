import java.util.Arrays;

public class Lc75 {

    static class Solution {

        // Swap two elements in the array
        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Dutch National Flag Algorithm
        public void sortColors(int[] nums) {

            int left = 0;
            int mid = 0;
            int high = nums.length - 1;

            while (mid <= high) {

                if (nums[mid] == 0) {
                    swap(nums, left, mid);
                    left++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else {
                    swap(nums, mid, high);
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(nums));

        obj.sortColors(nums);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(nums));
    }
}