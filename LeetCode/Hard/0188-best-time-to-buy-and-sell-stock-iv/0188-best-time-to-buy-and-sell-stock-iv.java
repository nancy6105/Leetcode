class Solution {
    int n;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        int dp[][][] = new int[n+1][k+1][2];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return sol(0,k,1,prices,dp);
    }
    int sol(int idx,int k,int buy,int [] arr,int dp[][][]){
        if(k == 0){
            return dp[idx][k][buy] = 0;
        }
        if(idx == n){
            return dp[idx][k][buy] = 0;
        }

        if(dp[idx][k][buy] != -1){
            return dp[idx][k][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -arr[idx]+sol(idx+1,k,0,arr,dp);
            int nottake = 0 + sol(idx+1,k,1,arr,dp);
            profit = Math.max(take,nottake);
        }
        else{
            int take = arr[idx] + sol(idx+1,k-1,1,arr,dp);
            int nottake = 0 + sol(idx+1,k,0,arr,dp);
            profit = Math.max(take,nottake);
        }

        return dp[idx][k][buy] = profit;
    }      
}