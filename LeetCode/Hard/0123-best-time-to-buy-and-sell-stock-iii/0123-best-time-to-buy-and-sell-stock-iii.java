class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int after[][] = new int[2][3];

        for (int idx = n - 1; idx >= 0; idx--) {
            int curr[][] = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[idx] + after[0][cap];
                        int nottake = 0 + after[1][cap];
                        profit = Math.max(take, nottake);
                    } else {
                        int take = prices[idx] + after[1][cap-1];
                        int nottake = 0 + after[0][cap];
                        profit = Math.max(take, nottake);
                    }
                    curr[buy][cap] = profit;
                }
            }
            after = curr;
        }
        return after[1][2];
    }

    int sol(int idx, int buy, int arr[], int cap, int dp[][][]) {
        int n = arr.length;
        if (cap == 0) {
            return 0;
        }

        if (idx == n) {
            return 0;
        }
        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        int profit = 0;
        if (buy == 1) {
            int take = -arr[idx] + sol(idx + 1, 0, arr, cap, dp);
            int nottake = 0 + sol(idx + 1, 1, arr, cap, dp);
            profit = Math.max(take, nottake);
        } else {
            int take = arr[idx] + sol(idx + 1, 1, arr, cap - 1, dp);
            int nottake = 0 + sol(idx + 1, 0, arr, cap, dp);
            profit = Math.max(take, nottake);
        }
        return dp[idx][buy][cap] = profit;
    }
}