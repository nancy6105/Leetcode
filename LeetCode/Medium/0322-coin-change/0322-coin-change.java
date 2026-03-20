class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i = 0;i<=amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }
        for(int i = 1;i<coins.length;i++){
            for(int t = 0;t<=amount;t++){
                int notpick = 0 + dp[i-1][t];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= t){
                    pick = 1 + dp[i][t-coins[i]];
                }
                dp[i][t] = Math.min(notpick,pick);
            }
        }
        int ans = dp[coins.length-1][amount];
        return ans >= (int)1e9 ? -1 : ans; 
    }
}