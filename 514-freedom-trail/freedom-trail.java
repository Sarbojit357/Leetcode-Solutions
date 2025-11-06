import java.util.Arrays;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        int[][] dp = new int[m + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: for the first character of key
        for (int j = 0; j < n; j++) {
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = Math.min(j, n - j) + 1; // +1 for pressing the button
            }
        }

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) { // Current character key[i] is at ring[j]
                if (ring.charAt(j) == key.charAt(i)) {
                    for (int k = 0; k < n; k++) { // Previous character key[i-1] was at ring[k]
                        if (dp[i - 1][k] != Integer.MAX_VALUE) {
                            int diff = Math.abs(j - k);
                            int steps = Math.min(diff, n - diff);
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + steps + 1);
                        }
                    }
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSteps = Math.min(minSteps, dp[m - 1][j]);
        }
        return minSteps;
    }
}