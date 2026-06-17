class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Step 1: find final length
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                len++;
            } else if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len = len * 2;
            } else if (ch == '%') {
                // reverse does not change length
            }
        }

        if (k >= len) return '.';

        // Step 2: go backward and find kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len--;
                if (k == len) return ch;
            } 
            else if (ch == '*') {
                len++; 
            } 
            else if (ch == '#') {
                len = len / 2;
                k = k % len;
            } 
            else if (ch == '%') {
                k = len - 1 - k;
            }
        }

        return '.';
    }
}