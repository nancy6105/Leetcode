class Solution {
    public int coinChange(int[] coins, int amount) {
        int prev[] = new int[amount+1];
        for(int i = 0;i<=amount;i++){
            if(i%coins[0] == 0){
                prev[i] = i/coins[0];
            }
            else{
                prev[i] = (int)1e9;
            }
        }
        for(int i = 1;i<coins.length;i++){
            int curr[] = new int[amount+1];
            for(int t = 0;t<=amount;t++){
                int notpick = 0 + prev[t];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= t){
                    pick = 1 + curr[t-coins[i]];
                }
                curr[t] = Math.min(notpick,pick);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return ans >= (int)1e9 ? -1 : ans; 
    }
}