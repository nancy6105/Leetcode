class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];

        int ans = 0;

        for(int num : nums){
            ans += max - num;
        }

        return ans;
    }
}