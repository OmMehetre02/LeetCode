import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();

        int degree = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];

            // Store the first occurrence index
            if (!firstIndex.containsKey(value)) {
                firstIndex.put(value, i);
            }

            // Increase frequency
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);

            int currentFrequency = frequency.get(value);
            int currentLength = i - firstIndex.get(value) + 1;

            if (currentFrequency > degree) {
                degree = currentFrequency;
                minLength = currentLength;
            } 
            else if (currentFrequency == degree) {
                minLength = Math.min(minLength, currentLength);
            }
        }

        return minLength;
    }
}