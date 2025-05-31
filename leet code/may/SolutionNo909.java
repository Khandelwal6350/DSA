import java.util.*;

public class SolutionNo909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {current square, moves}

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0], moves = curr[1];
            if (pos == n * n) return moves;

            for (int i = 1; i <= 6 && pos + i <= n * n; i++) {
                int next = pos + i;
                int[] coords = getCoordinates(next, n);
                int row = coords[0], col = coords[1];
                if (board[row][col] != -1) {
                    next = board[row][col];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
