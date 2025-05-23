public class Solution_Dice_throw {

    // Method to find number of ways to get sum X with n dice each having m faces
    public int noOfWays(int m, int n, int X) {
        int[][] dp = new int[n + 1][X + 1];
        dp[0][0] = 1; // base case: 0 dice to make sum 0

        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= X; sum++) {
                dp[dice][sum] = 0;
                for (int face = 1; face <= m; face++) {
                    if (sum - face >= 0) {
                        dp[dice][sum] += dp[dice - 1][sum - face];
                    }
                }
            }
        }

        return dp[n][X];
    }

    // Main method for quick local testing
    public static void main(String[] args) {
        Solution ob = new Solution();
        int M = 6;  // faces on each die
        int N = 3;  // number of dice
        int X = 8;  // target sum
        System.out.println(ob.noOfWays(M, N, X));
    }
}
