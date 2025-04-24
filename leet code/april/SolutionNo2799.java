import java.util.*;

public class SolutionNo2799 {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> unique = new HashSet<>();
        
        // Step 1: Find the total number of distinct elements in nums
        for (int num : nums) {
            unique.add(num);
        }
        int totalDistinct = unique.size();
        
        int result = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        
        // Step 2: Use a sliding window
        for (int right = 0; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            // While current window has all distinct elements
            while (freq.size() == totalDistinct) {
                result += n - right; // all subarrays starting at left and ending from right to n-1 are valid
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
