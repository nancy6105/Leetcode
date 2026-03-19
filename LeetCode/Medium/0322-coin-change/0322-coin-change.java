class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i = 0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans =  sol(coins.length-1,amount,coins,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    int sol(int idx,int k,int a[],int[][] dp){
        if(idx == 0){
            if(k % a[idx] == 0){
                return k/a[idx];
            }
            else{
                return (int)1e9;
            }
        }

        if(dp[idx][k] != -1)return dp[idx][k];


        int notpick = 0 + sol(idx-1,k,a,dp);
        int pick = Integer.MAX_VALUE;
        if(a[idx] <= k){
            pick = 1 + sol(idx,k-a[idx],a,dp);
        }
        return dp[idx][k] = Math.min(pick,notpick);
    }
}