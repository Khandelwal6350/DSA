import java.util.Arrays;

class SolutionNo2962 {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long result = 0;
        int count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == maxNum) {
                count++;
            }

            while (count >= k) {
                result += n - right;
                if (nums[left] == maxNum) {
                    count--;
                }
                left++;
            }
        }

        return result;
    }
}
