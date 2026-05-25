class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];//0 -> false, 1 -> true
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return sol(0, 1, prices, dp);
    }
    int sol(int idx, int buy, int[] arr,int dp[][]){
        if(idx == arr.length){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(profit - arr[idx] + sol(idx+1, 0, arr,dp), 0 + sol(idx+1, 1, arr,dp));    
        }
        else{
            profit = Math.max(profit + arr[idx] + sol(idx+1, 1, arr, dp), 0 + sol(idx+1, 0, arr, dp));    
        }
        return dp[idx][buy] = profit;
    }
}