class Solution {
    int[] dp = new int[100001];

    public boolean winnerSquareGame(int n) {
        if (n == 0) {
            return false;
        }

        if (dp[n] != 0) {
            return dp[n] == 1;
        }

        for (int i = 1; i * i <= n; i++) {
            if (!winnerSquareGame(n - i * i)) {
                dp[n] = 1;
                return true;
            }
        }

        dp[n] = -1;
        return false;
    }
}
