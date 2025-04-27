class SolutionNo3392 {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 1; i + 1 < nums.length; i++) {
            if (nums[i] == 2 * (nums[i - 1] + nums[i + 1])) {
                count++;
            }
        }
        return count;
    }
}
