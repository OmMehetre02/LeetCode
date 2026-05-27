class Solution {
    public int findNthDigit(int n) {

        long digit = 1;
        long count = 9;
        long start = 1;

        // Find number length
        while (n > digit * count) {
            n -= digit * count;
            digit++;
            count *= 10;
            start *= 10;
        }

        // Find actual number
        start = start + (n - 1) / digit;

        // Convert number to string
        String s = Long.toString(start);

        // Return digit
        return s.charAt((n - 1) % (int)digit) - '0';
    }
}