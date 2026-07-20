class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {

            char current = num.charAt(i);

            while (stack.length() > 0 &&
                   k > 0 &&
                   stack.charAt(stack.length() - 1) > current) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(current);
        }

        // Remove remaining digits from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeroes
        int index = 0;

        while (index < stack.length() &&
               stack.charAt(index) == '0') {
            index++;
        }

        String answer = stack.substring(index);

        if (answer.length() == 0) {
            return "0";
        }

        return answer;
    }
}