import java.util.*;

class Solution {
    public List<Integer> findValidElements(int[] nums) {

        int n = nums.length;

        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        // Store maximum from right side
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        List<Integer> ans = new ArrayList<>();

        int leftMax = 0;

        for (int i = 0; i < n; i++) {

            // First element, Last element,
            // Greater than all left OR greater than all right
            if (i == 0 || i == n - 1 ||
                nums[i] > leftMax ||
                nums[i] > rightMax[i + 1]) {

                ans.add(nums[i]);
            }

            leftMax = Math.max(leftMax, nums[i]);
        }

        return ans;
    }
}