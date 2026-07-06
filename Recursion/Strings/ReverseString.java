public class ReverseString {

    public static String reverse(String str) {
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap characters
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "Hello World";

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverse(str));
    }
}