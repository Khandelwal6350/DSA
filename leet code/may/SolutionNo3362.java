import java.util.*;

class SolutionNo3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>(); // Min-heap (stores end indices)
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap (stores end indices)

        // Sort queries by start index
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int queryPos = 0;
        int appliedCount = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries starting at index i to availableQuery
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }

            // Remove expired queries from usedQuery
            while (!usedQuery.isEmpty() && usedQuery.peek() < i) {
                usedQuery.poll();
            }

            // Adjust nums[i] by subtracting the number of active queries
            nums[i] -= usedQuery.size();

            // Apply additional queries as needed
            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }

            // If nums[i] couldn't be reduced to zero
            if (nums[i] > 0) {
                return -1;
            }
        }

        return queries.length - appliedCount;
    }
}
