class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int maxDuration = releaseTimes[0];
        char answer = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {

            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);

            if (duration > maxDuration) {
                maxDuration = duration;
                answer = currentKey;
            } 
            else if (duration == maxDuration && currentKey > answer) {
                answer = currentKey;
            }
        }

        return answer;
    }
}