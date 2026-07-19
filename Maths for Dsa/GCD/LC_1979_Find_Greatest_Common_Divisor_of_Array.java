public class LC_1979_Find_Greatest_Common_Divisor_of_Array {

    static class Solution {
        public int findGCD(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }

            return gcd(min, max);
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 5, 6, 9, 10};
        System.out.println(sol.findGCD(nums1)); // 2

        int[] nums2 = {7, 5, 6, 8, 3};
        System.out.println(sol.findGCD(nums2)); // 1

        int[] nums3 = {3, 3};
        System.out.println(sol.findGCD(nums3)); // 3

        int[] nums4 = {12, 24, 36, 48};
        System.out.println(sol.findGCD(nums4)); // 12
    }
}