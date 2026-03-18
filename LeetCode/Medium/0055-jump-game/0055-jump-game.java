class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[nums.length];
        dp[n-1] = true;
        for(int i = n-2;i>=0;i--){
            for(int j = 1;j<=nums[i];j++){
                if(dp[i+j]){
                    dp[i] = true;
                    break; 
                }
            }
        }
        return dp[0];
    }
}