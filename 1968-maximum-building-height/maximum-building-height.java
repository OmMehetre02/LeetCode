import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;

        int[][] arr = new int[m + 2][2];

        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i = 0; i < m; i++) {
            arr[i + 1][0] = restrictions[i][0];
            arr[i + 1][1] = restrictions[i][1];
        }

        arr[m + 1][0] = n;
        arr[m + 1][1] = n - 1;

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // left to right
        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i][0] - arr[i - 1][0];
            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + distance);
        }

        // right to left
        for (int i = arr.length - 2; i >= 0; i--) {
            int distance = arr[i + 1][0] - arr[i][0];
            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + distance);
        }

        int ans = 0;

        for (int i = 1; i < arr.length; i++) {
            int h1 = arr[i - 1][1];
            int h2 = arr[i][1];
            int distance = arr[i][0] - arr[i - 1][0];

            int peak = (h1 + h2 + distance) / 2;
            ans = Math.max(ans, peak);
        }

        return ans;
    }
}