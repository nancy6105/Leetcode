class Solution {
    int n;

    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        int dp[][][] = new int[n + 1][k + 1][2];
        for (int idx = 0; idx <= n; idx++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[idx][0][buy] = 0;
            }
        }

        for (int j = 0; j <= k; j++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[n][j][buy] = 0;
            }
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int j = 1; j <= k; j++) {
                for (int buy = 0; buy < 2; buy++) {
                    int profit = 0;
                    if (buy == 1) {
                        int take = -prices[idx] + dp[idx + 1][j][0];
                        int nottake = 0 + dp[idx + 1][j][1];
                        profit = Math.max(take, nottake);
                    } else {
                        int take = prices[idx] + dp[idx + 1][j - 1][1];
                        int nottake = 0 + dp[idx + 1][j][0];
                        profit = Math.max(take, nottake);
                    }
                    dp[idx][j][buy] = profit;
                }
            }
        }
        return dp[0][k][1];
    }
}