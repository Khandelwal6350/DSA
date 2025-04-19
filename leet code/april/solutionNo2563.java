import java.util.Arrays;

public class solutionNo2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            count += (right - left);
        }

        return count;
    }

    // Find the first index where nums[i] >= target
    private int lowerBound(int[] nums, int start, int end, int target) {
        int l = start, r = end + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    // Find the first index where nums[i] > target
    private int upperBound(int[] nums, int start, int end, int target) {
        int l = start, r = end + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
