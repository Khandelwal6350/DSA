import java.util.*;

class SolutionNo3373 {
    static class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    // BFS function to count nodes at even levels and optionally mark them
    private int bfs(int start, List<List<Integer>> adj, boolean[] included) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, -1));
        int count = 0;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level % 2 == 0) {
                count += size;
            }

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currNode = current.node;
                int parent = current.parent;

                if (included != null && level % 2 == 0) {
                    included[currNode] = true;
                }

                for (int neighbor : adj.get(currNode)) {
                    if (neighbor != parent) {
                        queue.add(new Pair(neighbor, currNode));
                    }
                }
            }
            level++;
        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n1; i++) adj1.add(new ArrayList<>());
        for (int i = 0; i < n2; i++) adj2.add(new ArrayList<>());

        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        // Step 1: Find the maximum count of nodes at even or odd levels in tree2
        int evenCount2 = bfs(0, adj2, null);
        int oddCount2 = n2 - evenCount2;
        int best2 = Math.max(evenCount2, oddCount2);

        // Step 2: Run BFS on tree1 and record nodes at even levels
        boolean[] included = new boolean[n1];
        int evenCount1 = bfs(0, adj1, included);

        // Step 3: For each node in tree1, calculate the maximum target nodes
        int[] result = new int[n1];
        for (int i = 0; i < n1; i++) {
            if (included[i]) {
                result[i] = evenCount1 + best2;
            } else {
                result[i] = (n1 - evenCount1) + best2;
            }
        }

        return result;
    }
}
