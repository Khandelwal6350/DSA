import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        for (int ops = 0; ops * 3 <= n; ops++) {
            Set<Integer> seen = new HashSet<>();
            boolean allUnique = true;

            for (int i = ops * 3; i < n; i++) {
                if (!seen.add(nums[i])) {
                    allUnique = false;
                    break;
                }
            }

            if (allUnique) {
                return ops;
            }
        }

        return (n + 2) / 3;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        System.out.println("Minimum operations: " + sol.minimumOperations(nums)); // Output: 2
    }
}