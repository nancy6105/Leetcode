class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        return sol(nums,0,dp);
    }
    int sol(int arr[], int idx, int dp[]){
        if(idx >= arr.length-1){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int min = Integer.MAX_VALUE;

        for(int i = 1;i <= arr[idx];i++){
            int ans = sol(arr, i + idx,dp);
            if(ans != Integer.MAX_VALUE){
                min = Math.min(1 + ans,min);
            }
        }

        return dp[idx] = min;
    }
}