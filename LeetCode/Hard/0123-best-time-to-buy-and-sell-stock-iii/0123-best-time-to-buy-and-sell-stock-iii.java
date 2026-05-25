class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int rows[][] : dp){
            for(int row[] : rows){
                Arrays.fill(row,-1);
            }
        }

        return sol(0,1,prices,2,dp);
    }
    int sol(int idx, int buy, int arr[], int cap,int dp[][][]){ 
        int n = arr.length;
        if(cap == 0){
            return 0;
        }

        if(idx == n){
            return 0;
        }
        if(dp[idx][buy][cap] != -1){
            return dp[idx][buy][cap];
        }

        int profit = 0;
        if(buy == 1){
            int take = -arr[idx] + sol(idx+1,0,arr,cap,dp);
            int nottake = 0 + sol(idx+1,1,arr,cap,dp);
            profit = Math.max(take,nottake);
        }
        else{
            int take = arr[idx] + sol(idx+1,1,arr,cap-1,dp);
            int nottake = 0 + sol(idx+1,0,arr,cap,dp);
            profit = Math.max(take,nottake);
        }
        return dp[idx][buy][cap] = profit;
    }
}