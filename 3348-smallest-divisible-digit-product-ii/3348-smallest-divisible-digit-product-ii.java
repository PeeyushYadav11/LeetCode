import java.util.Arrays;

class Solution {
    
    private static final int[][] dp = new int[65][45];

    static {
        for (int[] row : dp) {
            Arrays.fill(row, 10000);
        }
        dp[0][0] = 0;
        for (int i = 0; i < 65; i++) {
            for (int j = 0; j < 45; j++) {
                if (dp[i][j] >= 10000) continue;
                
                dp[Math.min(64, i + 1)][j] = Math.min(dp[Math.min(64, i + 1)][j], dp[i][j] + 1); // 2
                dp[i][Math.min(44, j + 1)] = Math.min(dp[i][Math.min(44, j + 1)], dp[i][j] + 1); // 3
                dp[Math.min(64, i + 2)][j] = Math.min(dp[Math.min(64, i + 2)][j], dp[i][j] + 1); // 4
                dp[Math.min(64, i + 1)][Math.min(44, j + 1)] = Math.min(dp[Math.min(64, i + 1)][Math.min(44, j + 1)], dp[i][j] + 1); // 6
                dp[Math.min(64, i + 3)][j] = Math.min(dp[Math.min(64, i + 3)][j], dp[i][j] + 1); // 8
                dp[i][Math.min(44, j + 2)] = Math.min(dp[i][Math.min(44, j + 2)], dp[i][j] + 1); // 9
            }
        }
    }

    
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        long temp = t;
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;

        while (temp % 2 == 0) { temp /= 2; c2++; }
        while (temp % 3 == 0) { temp /= 3; c3++; }
        while (temp % 5 == 0) { temp /= 5; c5++; }
        while (temp % 7 == 0) { temp /= 7; c7++; }

        if (temp > 1) return "-1";

        int n = num.length();
        int zeroIdx = num.indexOf('0');
        int maxLen = (zeroIdx != -1) ? zeroIdx : n;

        int[][] req = new int[n + 1][4];
        req[0] = new int[]{c2, c3, c5, c7};

        for (int i = 0; i < maxLen; i++) {
            int d = num.charAt(i) - '0';
            req[i + 1][0] = Math.max(0, req[i][0] - DIGIT_FACTORS[d][0]);
            req[i + 1][1] = Math.max(0, req[i][1] - DIGIT_FACTORS[d][1]);
            req[i + 1][2] = Math.max(0, req[i][2] - DIGIT_FACTORS[d][2]);
            req[i + 1][3] = Math.max(0, req[i][3] - DIGIT_FACTORS[d][3]);
        }

        
        if (zeroIdx == -1 && req[n][0] == 0 && req[n][1] == 0 && req[n][2] == 0 && req[n][3] == 0) {
            return num;
        }

        
        for (int len = maxLen; len >= 0; len--) {
            if (len == n) continue;

            int startDigit = num.charAt(len) - '0' + 1;
            int r2 = req[len][0], r3 = req[len][1], r5 = req[len][2], r7 = req[len][3];

            for (int d = startDigit; d <= 9; d++) {
                int nr2 = Math.max(0, r2 - DIGIT_FACTORS[d][0]);
                int nr3 = Math.max(0, r3 - DIGIT_FACTORS[d][1]);
                int nr5 = Math.max(0, r5 - DIGIT_FACTORS[d][2]);
                int nr7 = Math.max(0, r7 - DIGIT_FACTORS[d][3]);

                int avail = n - 1 - len;
                if (canForm(nr2, nr3, nr5, nr7, avail)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0, len)).append(d);
                    sb.append(constructSuffix(nr2, nr3, nr5, nr7, avail));
                    return sb.toString();
                }
            }
        }

        
        int minLen = minDigits(c2, c3, c5, c7);
        int targetLen = Math.max(n + 1, minLen);
        return constructSuffix(c2, c3, c5, c7, targetLen);
    }

    private int minDigits(int c2, int c3, int c5, int c7) {
        return dp[c2][c3] + c5 + c7;
    }

    private boolean canForm(int c2, int c3, int c5, int c7, int avail) {
        return minDigits(c2, c3, c5, c7) <= avail;
    }

    private String constructSuffix(int c2, int c3, int c5, int c7, int len) {
        StringBuilder sb = new StringBuilder();
        int cur2 = c2, cur3 = c3, cur5 = c5, cur7 = c7;

        for (int i = 0; i < len; i++) {
            int remLen = len - 1 - i;
            for (int d = 1; d <= 9; d++) {
                int n2 = Math.max(0, cur2 - DIGIT_FACTORS[d][0]);
                int n3 = Math.max(0, cur3 - DIGIT_FACTORS[d][1]);
                int n5 = Math.max(0, cur5 - DIGIT_FACTORS[d][2]);
                int n7 = Math.max(0, cur7 - DIGIT_FACTORS[d][3]);

                if (canForm(n2, n3, n5, n7, remLen)) {
                    sb.append(d);
                    cur2 = n2; cur3 = n3; cur5 = n5; cur7 = n7;
                    break;
                }
            }
        }
        return sb.toString();
    }
}