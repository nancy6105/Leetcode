class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,Integer.MIN_VALUE);

        if(sol(0,nums,target,dp) < 0){
            return -1;
        }
        return sol(0,nums,target,dp);
    }

    int sol(int i,int nums[],int target,int[]dp){
        int n = nums.length;

        if(i == n-1)return dp[i] = 0;
        if(dp[i] != Integer.MIN_VALUE)return dp[i];

        int res = Integer.MIN_VALUE;
        for(int j = i+1;j<n;j++){
            if(Math.abs(nums[i]-nums[j]) <= target){
                int temp = 1+sol(j, nums, target, dp);
                res = Math.max(res, temp);
            }
        }

        return dp[i] = res;
    }
}