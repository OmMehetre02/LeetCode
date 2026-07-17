class Solution {
    public int countElements(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Count elements between min and max
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != min && nums[i] != max) {
                count++;
            }
        }

        return count;
    }
}