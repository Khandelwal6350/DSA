class solutionNo1922 {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // Even indices → even digits → 5 choices
        long oddPositions = n / 2;        // Odd indices → prime digits → 4 choices

        long evenChoices = modPow(5, evenPositions, MOD);
        long oddChoices = modPow(4, oddPositions, MOD);

        return (int)((evenChoices * oddChoices) % MOD);
    }

    // Fast modular exponentiation
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
