class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return sol(0,nums,dp);
    }
    boolean sol(int idx,int[]a,int[]dp){
        if(idx >= a.length-1){
            return true;
        }
        if(dp[idx]!=-1){
            return dp[idx] == 1;
        }
        for(int i = 1;i<=a[idx];i++){
            if(sol(idx+i,a,dp)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}