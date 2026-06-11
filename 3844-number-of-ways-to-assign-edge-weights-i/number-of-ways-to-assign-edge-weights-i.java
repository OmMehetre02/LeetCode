import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int MOD = 1000000007;
        int n = edges.length + 1;

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int depth = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            while (size-- > 0) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        long ans = 1;
        for (int i = 0; i < depth - 1; i++) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }
}