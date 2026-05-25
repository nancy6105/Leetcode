class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return sol(n-1,nums,dp);
    }
    int sol(int idx, int nums[],int dp[]){
        if(idx < 0){
            return 0;
        }
        if(idx == 0){
            return nums[idx];
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int pick = nums[idx] + sol(idx-2,nums,dp);
        int notpick = 0 + sol(idx-1,nums,dp );

        return dp[idx] = Math.max(pick,notpick);

    }
}