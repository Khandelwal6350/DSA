import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SolutionNo2845 {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        Map<Integer, Long> prefixMap = new HashMap<>();
        prefixMap.put(0, 1L); 

        int count = 0;
        long result = 0;

        for (int num : nums) {
            if (num % mod == k) {
                count++;
            }

            int currentMod = count % mod;
            int needed = (currentMod - k + mod) % mod;

            result += prefixMap.getOrDefault(needed, 0L);
            prefixMap.put(currentMod, prefixMap.getOrDefault(currentMod, 0L) + 1);
        }

        return result;
    }
}
