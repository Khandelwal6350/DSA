import java.util.HashSet;
import java.util.Set;

public class solutionNo3375{
    public int minOperations(int[] nums, int k) {
        Set<Integer> uniqueValues = new HashSet<>();
        int minValue = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            uniqueValues.add(num);
            minValue = Math.min(minValue, num);
        }

       
        return uniqueValues.size() - (minValue == k ? 1 : 0);
    }
}
