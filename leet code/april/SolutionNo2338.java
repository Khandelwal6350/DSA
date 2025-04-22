import java.util.*;

public class SolutionNo2338 {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_EXP = 14;
    private long[][] comb = new long[20010][MAX_EXP + 1]; // Increased from 10010

    public int idealArrays(int n, int maxValue) {
        precomputeCombinations(n + MAX_EXP);  // ensure we stay within bounds
        int[] spf = sieve(maxValue);  // Smallest Prime Factor for fast factorization
        long result = 0;

        for (int num = 1; num <= maxValue; num++) {
            Map<Integer, Integer> factorCounts = primeFactorCount(num, spf);
            long ways = 1;

            for (int exp : factorCounts.values()) {
                ways = (ways * comb[n + exp - 1][exp]) % MOD;
            }

            result = (result + ways) % MOD;
        }

        return (int) result;
    }

    // Precompute combinations using Pascal's Triangle
    private void precomputeCombinations(int size) {
        for (int i = 0; i <= size; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_EXP); j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
    }

    // Generate smallest prime factor (SPF) array
    private int[] sieve(int n) {
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
        return spf;
    }

    // Get prime factor counts using SPF
    private Map<Integer, Integer> primeFactorCount(int x, int[] spf) {
        Map<Integer, Integer> count = new HashMap<>();
        while (x > 1) {
            int factor = spf[x];
            count.put(factor, count.getOrDefault(factor, 0) + 1);
            x /= factor;
        }
        return count;
    }
}
