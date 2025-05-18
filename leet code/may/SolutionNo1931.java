import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        Map<Integer, List<Integer>> transitions = new HashMap<>();

        generateStates(m, 0, new int[m], states);

        int stateCount = states.size();
        for (int i = 0; i < stateCount; i++) {
            List<Integer> compatible = new ArrayList<>();
            for (int j = 0; j < stateCount; j++) {
                if (isCompatible(states.get(i), states.get(j))) {
                    compatible.add(j);
                }
            }
            transitions.put(i, compatible);
        }

        int[] dp = new int[stateCount];
        Arrays.fill(dp, 1); // base case: one way to paint the first column with each valid pattern

        for (int col = 1; col < n; col++) {
            int[] newDp = new int[stateCount];
            for (int i = 0; i < stateCount; i++) {
                for (int prev : transitions.get(i)) {
                    newDp[i] = (newDp[i] + dp[prev]) % MOD;
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp) {
            result = (result + val) % MOD;
        }
        return result;
    }

    private void generateStates(int m, int pos, int[] curr, List<int[]> result) {
        if (pos == m) {
            result.add(curr.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (pos == 0 || curr[pos - 1] != color) {
                curr[pos] = color;
                generateStates(m, pos + 1, curr, result);
            }
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
