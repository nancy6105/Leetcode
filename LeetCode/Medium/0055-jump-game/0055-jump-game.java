class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,-1);
        return sol(nums,0,dp);
    }
    private boolean sol(int[] arr,int idx,int dp[]){
        if(idx >= arr.length-1){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1;
        }
        for(int jump = 1;jump <= arr[idx];jump++){
            if(sol(arr,idx+jump,dp)){
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }
}