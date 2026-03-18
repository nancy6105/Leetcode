class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int n = nums.length;
        if(sum%2 != 0)return false;
        int dp[][] = new int[n][sum+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(nums.length-1,sum/2,nums,dp);
    }
    boolean sol(int idx,int k,int a[],int dp[][]){
        if(k == 0)return true;
        if(idx == 0)return a[0] == k;
        if(dp[idx][k] != -1){
            return dp[idx][k] == 1;
        }
        boolean nottake = sol(idx-1,k,a,dp);
        boolean take = false;
        if(k >= a[idx]){
            take = sol(idx-1,k-a[idx],a,dp);
        }
        dp[idx][k] = (take || nottake) ? 1:0;
        return take || nottake;
    }
}