public class SolutionNo3343 {
    private static final int MOD = 1_000_000_007;
    private int[] digitCount = new int[10];
    private Long[][][][] memo;
    private long[][] combinations;

    public int countBalancedPermutations(String num) {
        int totalSum = 0;
        for (char c : num.toCharArray()) {
            int digit = c - '0';
            digitCount[digit]++;
            totalSum += digit;
        }

        if (totalSum % 2 != 0) {
            return 0;
        }

        int n = num.length();
        int halfSum = totalSum / 2;
        int oddPositions = n / 2;
        int evenPositions = (n + 1) / 2;

        memo = new Long[10][halfSum + 1][oddPositions + 1][evenPositions + 1];
        precomputeCombinations(n);

        return (int) dfs(0, halfSum, oddPositions, evenPositions);
    }

    private long dfs(int digit, int remainingSum, int oddLeft, int evenLeft) {
        if (digit == 10) {
            return (remainingSum == 0 && oddLeft == 0 && evenLeft == 0) ? 1 : 0;
        }

        if (memo[digit][remainingSum][oddLeft][evenLeft] != null) {
            return memo[digit][remainingSum][oddLeft][evenLeft];
        }

        long totalWays = 0;
        int count = digitCount[digit];
        for (int oddCount = 0; oddCount <= Math.min(count, oddLeft); oddCount++) {
            int evenCount = count - oddCount;
            if (evenCount > evenLeft) {
                continue;
            }
            int sumContribution = digit * oddCount;
            if (sumContribution > remainingSum) {
                continue;
            }

            long ways = (combinations[oddLeft][oddCount] * combinations[evenLeft][evenCount]) % MOD;
            ways = (ways * dfs(digit + 1, remainingSum - sumContribution, oddLeft - oddCount, evenLeft - evenCount)) % MOD;
            totalWays = (totalWays + ways) % MOD;
        }

        memo[digit][remainingSum][oddLeft][evenLeft] = totalWays;
        return totalWays;
    }

    private void precomputeCombinations(int n) {
        combinations = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = combinations[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }
    }
}
