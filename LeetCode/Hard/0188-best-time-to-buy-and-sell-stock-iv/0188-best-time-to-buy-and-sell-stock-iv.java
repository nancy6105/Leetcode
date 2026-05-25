class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        for(int idx = n-1;idx >= 0;idx--){
            for(int buy = 0;buy <= 1;buy++){
                for(int trans = 1; trans < k+1; trans++){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[idx] + dp[idx+1][0][trans];
                        int nottake = 0 + dp[idx+1][1][trans];
                        profit = Math.max(take,nottake);
                    }
                    else{
                        int take = prices[idx] + dp[idx+1][1][trans-1];
                        int nottake = 0 + dp[idx+1][0][trans];
                        profit = Math.max(take,nottake);
                    }
                    dp[idx][buy][trans] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}