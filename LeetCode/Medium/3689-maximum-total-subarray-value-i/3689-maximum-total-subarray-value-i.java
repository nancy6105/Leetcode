class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int max = nums[0];
        int min = nums[0];
        for(int i = 1;i<n;i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        return (long)(max-min)*k;
    }
}