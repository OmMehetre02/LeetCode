import java.util.Arrays;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int[][] arr = new int[nums.length][2];

        // Store value and original index
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value in descending order
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        // Select the k largest elements
        int[][] selected = new int[k][2];

        for (int i = 0; i < k; i++) {
            selected[i] = arr[i];
        }

        // Sort selected elements by their original index
        Arrays.sort(selected, (a, b) -> Integer.compare(a[1], b[1]));

        // Create the answer
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = selected[i][0];
        }

        return answer;
    }
}