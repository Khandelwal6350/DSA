class SolutionNo2894 {
    public int differenceOfSums(int n, int m) {
        int sumDivisible = 0;
        int sumNonDivisible = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sumDivisible += i;
            } else {
                sumNonDivisible += i;
            }
        }

        // Correct logic: subtract divisible from non-divisible
        return sumNonDivisible - sumDivisible;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example input: n = 5, m = 1
        int n = 5;
        int m = 1;

        int result = sol.differenceOfSums(n, m);
        System.out.println("Result: " + result);  // Expected: -15
    }
}
