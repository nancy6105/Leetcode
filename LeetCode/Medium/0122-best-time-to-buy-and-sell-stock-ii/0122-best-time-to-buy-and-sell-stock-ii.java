class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[] = new int[2];
        ahead[0] = 0;
        ahead[1] = 0;

        for(int i = n-1;i >= 0; i--){
            int curr[] = new int[2];

            for(int j = 0;j <= 1;j++){
                int profit = 0;

                if(j == 1){
                    profit = Math.max(profit - prices[i] + ahead[0], 0 + ahead[1]);
                }
                else{
                    profit = Math.max(profit + prices[i] + ahead[1], 0 + ahead[0]);
                }
                curr[j] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}