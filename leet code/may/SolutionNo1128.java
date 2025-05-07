import java.util.HashMap;
import java.util.Map;

public class SolutionNo1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = a * 10 + b; // Unique key for domino [a, b]

            count += map.getOrDefault(key, 0); // Add the number of previous matches
            map.put(key, map.getOrDefault(key, 0) + 1); // Update count
        }

        return count;
    }
}
