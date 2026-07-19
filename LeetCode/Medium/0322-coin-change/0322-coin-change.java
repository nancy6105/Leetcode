class Solution {
    int n;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;

        int dp[][] = new int[n][amount+1];
        
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = sol(n-1,coins,amount,dp);

        return ans >= (int)1e9 ? -1 : ans;
    }
    int sol(int idx,int arr[],int amt,int dp[][]){
        if(idx == 0){
            if(amt%arr[idx] == 0){
                return amt/arr[idx];
            }
            else{
                return (int) 1e9;
            }
        }
        if(dp[idx][amt] != -1)return dp[idx][amt];

        int notpick = 0 + sol(idx-1,arr,amt,dp);
        int pick = Integer.MAX_VALUE;
        if(arr[idx] <= amt){
            pick = 1 + sol(idx,arr,amt-arr[idx],dp);
        }

        return dp[idx][amt] = Math.min(pick,notpick);
    }
}