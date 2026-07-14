class Solution {
    public int[] findEvenNumbers(int[] digits) {

        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {

            // First digit cannot be 0
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {

                // Cannot use the same index again
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < n; k++) {

                    // All three indices must be different
                    if (k == i || k == j) {
                        continue;
                    }

                    // Last digit must be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int number =
                            digits[i] * 100
                          + digits[j] * 10
                          + digits[k];

                    set.add(number);
                }
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;

        for (int number : set) {
            answer[index++] = number;
        }

        Arrays.sort(answer);

        return answer;
    }
}