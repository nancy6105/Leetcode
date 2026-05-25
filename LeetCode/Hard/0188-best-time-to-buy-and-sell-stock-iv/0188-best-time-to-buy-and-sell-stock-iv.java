class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k+1];
        for(int rows[][] : dp){
            for(int row[] : rows){
                Arrays.fill(row,-1);
            }
        }

        return sol(0,1,k,prices,dp);
    }
    int sol(int idx,int buy,int trans,int arr[],int dp[][][]){
        int n = arr.length;
        if(trans == 0){
            return 0;
        }
        if(idx == n){
            return 0;
        }
        if(dp[idx][buy][trans] != -1){
            return dp[idx][buy][trans];
        }
        int profit = 0;

        if(buy == 1){
            int take = -arr[idx] + sol(idx+1,0,trans,arr,dp);
            int nottake = 0 + sol(idx+1,1,trans,arr,dp);
            profit = Math.max(take,nottake);
        }
        else{
            int take = arr[idx] + sol(idx+1,1,trans-1,arr,dp);
            int nottake = 0 + sol(idx+1,0,trans,arr,dp);
            profit = Math.max(take,nottake);
        }
        return dp[idx][buy][trans] = profit;
    }
}