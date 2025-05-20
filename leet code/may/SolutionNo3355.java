class SolutionNo3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // Difference array of size n+1

        // Apply the difference array technique for each query
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            diff[start] += 1;
            if (end + 1 < n) {
                diff[end + 1] -= 1;
            }
        }

        int current = 0; // To store the prefix sum
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (current < nums[i]) {
                return false; // Not enough decrements to reduce nums[i] to 0
            }
        }

        return true; // All elements can be reduced to 0
    }
}
