import java.util.*;

public class SolutionNo3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long total = 0;
        int count = 0;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int normal = nums[i];
            int modified = nums[i] ^ k;

            // We prefer modified only if it increases value
            if (modified > normal) {
                total += modified;
                count++;
            } else {
                total += normal;
            }

            // Save the smallest diff if we need to switch one element later
            minDiff = Math.min(minDiff, Math.abs(modified - normal));
        }

        // We need an even number of XORed elements to simulate edge-based operations
        if (count % 2 == 0) {
            return total;
        } else {
            return total - minDiff;
        }
    }
}
