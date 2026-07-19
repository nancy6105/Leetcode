class Solution {
    int n;
    public int maxProfit(int[] prices) {
       n = prices.length;
       int dp[][][] = new int[n][2][3];
       for(int i = 0;i<n;i++){
        for(int j = 0;j<2;j++){
            Arrays.fill(dp[i][j],-1);
        }
       }
       return sol(0,1,prices,2,dp); 
    }

    int sol(int idx,int buy,int arr[],int cap,int dp[][][]){
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