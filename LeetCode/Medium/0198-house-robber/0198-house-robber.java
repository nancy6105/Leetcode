class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev0 = 0;
        int prev1 = nums[0];

        for(int i = 1; i < n; i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev0;
            }
            int notpick = prev1;
            int curr = Math.max(pick,notpick);
            prev0 = prev1;
            prev1 = curr;
        } 
        return prev1;
    }
}