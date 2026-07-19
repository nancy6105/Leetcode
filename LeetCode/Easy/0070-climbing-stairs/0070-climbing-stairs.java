class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return sol(n,dp);
    }
    int sol(int idx,int dp[]){
        if(idx == 0 || idx == 1 || idx == 2){
            return dp[idx] = idx;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        return dp[idx] = sol(idx-1,dp) + sol(idx-2,dp);
    }
}