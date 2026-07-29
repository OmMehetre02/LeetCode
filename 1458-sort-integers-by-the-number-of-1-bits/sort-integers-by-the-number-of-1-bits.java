class Solution {
    public int[] sortByBits(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                int bits1 = countBits(arr[j]);
                int bits2 = countBits(arr[j + 1]);

                if (bits1 > bits2 || (bits1 == bits2 && arr[j] > arr[j + 1])) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public int countBits(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }

        return count;
    }
}