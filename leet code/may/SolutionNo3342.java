import java.util.*;

class Solution {
    private static final int[] dir = {-1, 0, 1, 0, -1};

    static class Node {
        int r, c, time, cost;

        Node(int r, int c, int time, int cost) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        minHeap.offer(new Node(0, 0, 0, 1));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            if (curr.r == m - 1 && curr.c == n - 1)
                return curr.time;

            for (int i = 0; i < 4; ++i) {
                int newR = curr.r + dir[i];
                int newC = curr.c + dir[i + 1];
                int nextCost = curr.cost == 1 ? 2 : 1;

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC]) {
                    int waitTime = Math.max(curr.time, moveTime[newR][newC]);
                    int newTime = waitTime + curr.cost;
                    minHeap.offer(new Node(newR, newC, newTime, nextCost));
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
}
