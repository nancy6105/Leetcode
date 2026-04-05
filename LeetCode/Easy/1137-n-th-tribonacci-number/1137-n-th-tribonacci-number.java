class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return sol(n,dp);
    }
    int sol(int n,int dp[]){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        if(n == 1 || n == 2){
            return 1;
        }

        return dp[n] = sol(n-1,dp) + sol(n-2,dp) + sol(n-3,dp);
    }
}