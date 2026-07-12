import java.util.Arrays;
import java.util.HashMap;

public class LC1331 {

    public static int[] arrayRankTransform(int[] arr) {

        int[] nums = Arrays.copyOf(arr, arr.length);

        Arrays.sort(nums);

        int rankNo = 1;

        HashMap<Integer, Integer> rank = new HashMap<>();

        // Assign ranks to unique elements
        for (int num : nums) {
            if (!rank.containsKey(num)) {
                rank.put(num, rankNo);
                rankNo++;
            }
        }

        // Replace original values with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {40, 10, 20, 30};
        System.out.println("Test Case 1:");
        System.out.println(Arrays.toString(arrayRankTransform(arr1)));
        // Expected: [4, 1, 2, 3]

        // Test Case 2
        int[] arr2 = {100, 100, 100};
        System.out.println("\nTest Case 2:");
        System.out.println(Arrays.toString(arrayRankTransform(arr2)));
        // Expected: [1, 1, 1]

        // Test Case 3
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println("\nTest Case 3:");
        System.out.println(Arrays.toString(arrayRankTransform(arr3)));
        // Expected: [5, 3, 4, 2, 8, 6, 7, 1, 3]

        // Test Case 4
        int[] arr4 = {};
        System.out.println("\nTest Case 4:");
        System.out.println(Arrays.toString(arrayRankTransform(arr4)));
        // Expected: []

        // Test Case 5
        int[] arr5 = {7};
        System.out.println("\nTest Case 5:");
        System.out.println(Arrays.toString(arrayRankTransform(arr5)));
        // Expected: [1]
    }
}