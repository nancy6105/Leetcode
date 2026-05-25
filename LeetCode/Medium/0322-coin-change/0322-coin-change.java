class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        int ans = sol(coins.length-1,coins,amount,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    int sol(int idx,int arr[],int amt,int dp[][]){
        if(idx == 0){
            if(amt % arr[0] == 0){
                return amt/arr[0];
            }
            else{
                return (int)1e9;
            }
        }

        if(dp[idx][amt] != -1){
            return dp[idx][amt];
        }

        int notpick = sol(idx-1,arr,amt,dp);
        int pick = (int)1e9;
        if(arr[idx] <= amt){
            pick = 1 + sol(idx,arr,amt-arr[idx],dp);
        }

        return dp[idx][amt] = Math.min(pick,notpick);
    }
}