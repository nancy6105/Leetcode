class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return sol(n-1,nums,dp);
    }
    int sol(int idx,int arr[],int dp[]){
        if(idx == 0){
            return dp[idx] = arr[idx];
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = arr[idx] + sol(idx-2,arr,dp);
        int notpick = 0 + sol(idx-1,arr,dp);

        return dp[idx] = Math.max(pick,notpick);
    }
}