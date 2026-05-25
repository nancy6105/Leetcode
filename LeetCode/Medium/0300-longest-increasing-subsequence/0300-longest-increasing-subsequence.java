class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return sol(0,nums,-1,dp);
    }
    int sol(int idx, int arr[], int prev, int dp[][]){
        int n = arr.length;
        if(idx == n)return 0;

        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }
        int notpick = sol(idx+1,arr,prev,dp);
        int pick = 0;
        if(prev == -1 || arr[idx] > arr[prev]){
            pick = 1 + sol(idx+1,arr,idx,dp);
        }

        return dp[idx][prev+1] = Math.max(pick,notpick);
    }
}