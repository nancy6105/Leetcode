class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int next[] = new int[n+1];
        
        for(int idx = n-1; idx >= 0; idx--){
            int curr[] = new int[n+1];
            for(int prev = idx-1; prev >= -1; prev--){
                int notpick = next[prev+1];
                int pick = 0;
                if(prev == -1 || nums[prev] < nums[idx]){
                    pick = 1 + next[idx+1];
                }
                curr[prev+1] = Math.max(pick,notpick);
            }
            next = curr;
        }

        return next[0];
    }
}