class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(coins.length-1,amount,coins,dp);
    }
    int sol(int i,int k,int a[],int dp[][]){
        if(i == 0){
            if(k%a[0] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][k] != -1)return dp[i][k];

        int notpick = sol(i-1,k,a,dp);
        int pick = 0;
        if(a[i] <= k){
            pick = sol(i,k-a[i],a,dp);
        }
        return dp[i][k] = pick + notpick;
    }
}