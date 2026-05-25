class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int amt = 0; amt <= amount; amt++){
            if(amt%coins[0] == 0){
                prev[amt] = amt/coins[0];
            }
            else{
                prev[amt] = (int)1e9;
            }
        }

        for(int i = 1; i<n; i++){
            int curr[] = new int[amount+1];
            for(int amt = 0; amt <= amount; amt++){
                int notpick = prev[amt];
                int pick = (int)1e9;
                if(coins[i] <= amt){
                    pick = 1 + curr[amt-coins[i]];
                }

                curr[amt] = Math.min(pick,notpick);
            }
            prev = curr;
        }

        int ans = prev[amount];
        return ans >= (int)1e9 ? -1 : ans;
    }
}