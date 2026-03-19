class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(0,-1,nums,dp);
    }
    int sol(int idx,int prev,int nums[],int dp[][]){
        if(idx == nums.length)return 0;

        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }
        int notpick = sol(idx+1,prev,nums,dp);
        int pick = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            pick = 1+sol(idx+1,idx,nums,dp);
        } 
        return dp[idx][prev+1] = Math.max(pick,notpick);
    }
}