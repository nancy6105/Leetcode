class Solution {
    int n;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;

        int prev[] = new int[amount+1];
        for(int amt = 0;amt <= amount;amt++){
            if(amt%coins[0] == 0){
                prev[amt] = amt/coins[0];
            }
            else{
                prev[amt] = (int)1e9;
            }
        }


        for(int i = 1;i<n;i++){
            int curr[] = new int[amount+1];
            for(int amt = 0;amt<=amount;amt++){
                int notpick = 0 + prev[amt];
                int pick = Integer.MAX_VALUE;
                if(amt >= coins[i]){
                    pick = 1 + curr[amt - coins[i]];
                }

                curr[amt] = Math.min(notpick,pick);
            }
            prev = curr;
        }
        int ans = prev[amount];

        return ans >= (int)1e9 ? -1 : ans;
    }
}