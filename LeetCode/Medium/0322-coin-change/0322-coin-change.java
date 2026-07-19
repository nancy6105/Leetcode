class Solution {
    int n;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;

        int dp[][] = new int[n][amount+1];
        
        for(int amt = 0;amt<=amount;amt++){
            if(amt%coins[0] == 0){
                dp[0][amt] = amt/coins[0];
            }
            else{
                dp[0][amt] = (int)1e9;
            }
        }

        for(int i = 1;i<n;i++){
            for(int amt = 0;amt<=amount;amt++){
                int notpick = 0 + dp[i-1][amt];
                int pick = Integer.MAX_VALUE;
                if(amt >= coins[i]){
                    pick = 1 + dp[i][amt - coins[i]];
                }

                dp[i][amt] = Math.min(notpick,pick);
            }
        }
        int ans = dp[n-1][amount];

        return ans >= (int)1e9 ? -1 : ans;
    }
}