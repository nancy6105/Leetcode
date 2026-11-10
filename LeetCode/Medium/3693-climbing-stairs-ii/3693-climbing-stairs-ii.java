class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

        return sol(0,n,costs,dp);
    }

    int sol(int i, int n, int[] arr,int dp[]){
        if(i == n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;

        for(int j = 1; j <= 3; j++){
            if(i + j <= n){
                int cost = sol(i+j, n, arr, dp) + arr[i + j - 1] + j*j;
                ans = Math.min(cost, ans);
            }
        }

        return dp[i] = ans;
    }
}