import java.util.*;

public class SolutionNo3341 {
    // Directions: up, down, left, right
    private static final int[][] DIRECTIONS = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Initialize distance array with maximum values
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        // Priority queue to select the cell with the minimum time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {current_time, row, column}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currTime = current[0];
            int i = current[1];
            int j = current[2];

            // If we've reached the destination, return the time
            if (i == n - 1 && j == m - 1) {
                return currTime;
            }

            // Skip if we've already found a better path
            if (currTime > dist[i][j]) {
                continue;
            }

            // Explore adjacent cells
            for (int[] dir : DIRECTIONS) {
                int x = i + dir[0];
                int y = j + dir[1];

                // Check boundaries
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                // Calculate the earliest time we can enter the adjacent cell
                int nextTime = Math.max(currTime, moveTime[x][y]) + 1;

                // If this path is better, update and add to the queue
                if (nextTime < dist[x][y]) {
                    dist[x][y] = nextTime;
                    pq.offer(new int[]{nextTime, x, y});
                }
            }
        }

        // If the destination is unreachable
        return -1;
    }
}
