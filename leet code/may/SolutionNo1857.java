import java.util.*;

public class SolutionNo1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        
        // Build the graph
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        
        // Count of each color at each node (26 colors)
        int[][] colorCount = new int[n][26];
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize nodes with 0 indegree
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int visited = 0;
        int maxColorValue = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIndex]);
            
            for (int neighbor : graph[node]) {
                for (int i = 0; i < 26; ++i) {
                    colorCount[neighbor][i] = Math.max(colorCount[neighbor][i], colorCount[node][i]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return visited == n ? maxColorValue : -1;
    }
}
