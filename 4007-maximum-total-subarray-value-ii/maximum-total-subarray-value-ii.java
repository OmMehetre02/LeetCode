// class Solution {
//     public long maxTotalValue(int[] nums, int k) {
//         ArrayList<Integer> list = new ArrayList<>();
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             int max =nums[i];
//             int min = nums[i];
//             for(int j=i;j<n;j++){
//                 max=Math.max(max,nums[j]);
//                 min=Math.min(min,nums[j]);
//                 list.add(max-min);
//             }
//         }
//            Collections.sort(list, Collections.reverseOrder());
//            long sum=0;
//            for(int i=0;i<k;i++){
//             sum+=list.get(i);
//            }
//            return sum;
//     }
// }




class Solution {
    int[][] stMax, stMin;
    int[] log;
    int n;

    public long maxTotalValue(int[] nums, int k) {
        n = nums.length;
        build(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(getValue(cur.l, nr), cur.l, nr));
            }
        }

        return ans;
    }

    class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    private void build(int[] nums) {
        log = new int[n + 1];
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        int K = log[n] + 1;

        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(
                        stMax[j - 1][i],
                        stMax[j - 1][i + (1 << (j - 1))]
                );

                stMin[j][i] = Math.min(
                        stMin[j - 1][i],
                        stMin[j - 1][i + (1 << (j - 1))]
                );
            }
        }
    }

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int p = log[len];

        int mx = Math.max(
                stMax[p][l],
                stMax[p][r - (1 << p) + 1]
        );

        int mn = Math.min(
                stMin[p][l],
                stMin[p][r - (1 << p) + 1]
        );

        return (long) mx - mn;
    }
}