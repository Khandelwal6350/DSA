import java.util.HashMap;

public class solutionNo2537 {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        long pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            int curr = nums[right];
            int count = map.getOrDefault(curr, 0);
            pairs += count;
            map.put(curr, count + 1);

            while (pairs >= k) {
                res += (n - right);  // all subarrays ending at 'right' and starting from 'left' to 'right' are valid
                int leftVal = nums[left];
                int leftCount = map.get(leftVal);
                pairs -= (leftCount - 1); // remove the contribution of nums[left]
                map.put(leftVal, leftCount - 1);
                left++;
            }
        }
        
        return res;
    }
}
