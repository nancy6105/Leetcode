class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int after[][] = new int[2][k+1];
        for(int idx = n-1;idx >= 0;idx--){
            int curr[][] = new int[2][k+1];
            for(int buy = 0;buy <= 1;buy++){
                for(int trans = 1; trans < k+1; trans++){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[idx] + after[0][trans];
                        int nottake = 0 + after[1][trans];
                        profit = Math.max(take,nottake);
                    }
                    else{
                        int take = prices[idx] + after[1][trans-1];
                        int nottake = 0 + after[0][trans];
                        profit = Math.max(take,nottake);
                    }
                    curr[buy][trans] = profit;
                }
            }
            after = curr;
        }
        return after[1][k];
    }
}