import java.util.*;

public class SolutionNo3372 {
    static class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private int bfs(List<List<Integer>> adj, int start, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, -1));
        int count = 0;

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; ++i) {
                Pair current = queue.poll();
                int u = current.node;
                int parent = current.parent;
                for (int v : adj.get(u)) {
                    if (v != parent) {
                        queue.offer(new Pair(v, u));
                    }
                }
            }
            k--;
        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());
        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        // Preprocess: Find the maximum number of nodes reachable in Tree 2 within k - 1 steps
        int maxInTree2 = 0;
        for (int i = 0; i < m; ++i) {
            int reachable = bfs(adj2, i, k - 1);
            maxInTree2 = Math.max(maxInTree2, reachable);
        }

        // Calculate results for Tree 1
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int reachable = bfs(adj1, i, k);
            result[i] = reachable + maxInTree2;
        }

        return result;
    }
}