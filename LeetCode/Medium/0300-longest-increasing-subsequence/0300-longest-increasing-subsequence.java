class Solution {
    int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(0,-1,nums,dp);
    }
    int sol(int idx,int prev,int arr[],int dp[][]){
        if(idx == n)return 0;

        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }

        int notpick = 0 + sol(idx+1,prev,arr,dp);
        int pick = 0;
        if(prev == -1 || arr[idx] > arr[prev]){
            pick = 1 + sol(idx+1,idx,arr,dp);
        }
        return dp[idx][prev+1] = Math.max(pick,notpick);
    }
}