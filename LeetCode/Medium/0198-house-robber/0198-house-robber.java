class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        int prev0 = 0;
        int prev1 = nums[0];
        for(int i = 1;i<n;i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev0;
            }
            int notpick = prev1;
            prev0 = prev1;
            prev1 = Math.max(notpick,pick);
        }
        return prev1;
    }
}