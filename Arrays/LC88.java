import java.util.Arrays;

public class LC88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);

        System.out.println("Test Case 1:");
        System.out.println(Arrays.toString(nums1));
        // Expected: [1, 2, 2, 3, 5, 6]

        // Test Case 2
        int[] nums3 = {1};
        int[] nums4 = {};

        merge(nums3, 1, nums4, 0);

        System.out.println("Test Case 2:");
        System.out.println(Arrays.toString(nums3));
        // Expected: [1]

        // Test Case 3
        int[] nums5 = {0};
        int[] nums6 = {1};

        merge(nums5, 0, nums6, 1);

        System.out.println("Test Case 3:");
        System.out.println(Arrays.toString(nums5));
        // Expected: [1]

        // Test Case 4
        int[] nums7 = {4, 5, 6, 0, 0, 0};
        int[] nums8 = {1, 2, 3};

        merge(nums7, 3, nums8, 3);

        System.out.println("Test Case 4:");
        System.out.println(Arrays.toString(nums7));
        // Expected: [1, 2, 3, 4, 5, 6]
    }
}