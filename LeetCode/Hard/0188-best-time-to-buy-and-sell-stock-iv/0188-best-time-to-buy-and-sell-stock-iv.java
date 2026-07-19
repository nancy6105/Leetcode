class Solution {
    int n;

    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        int after[][] = new int[k+1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            int curr[][] = new int[k+1][2];
            for (int j = 1; j <= k; j++) {
                for (int buy = 0; buy < 2; buy++) {
                    int profit = 0;
                    if (buy == 1) {
                        int take = -prices[idx] + after[j][0];
                        int nottake = 0 + after[j][1];
                        profit = Math.max(take, nottake);
                    } else {
                        int take = prices[idx] + after[j - 1][1];
                        int nottake = 0 + after[j][0];
                        profit = Math.max(take, nottake);
                    }
                    curr[j][buy] = profit;
                }
            }
            after = curr;
        }
        return after[k][1];
    }
}