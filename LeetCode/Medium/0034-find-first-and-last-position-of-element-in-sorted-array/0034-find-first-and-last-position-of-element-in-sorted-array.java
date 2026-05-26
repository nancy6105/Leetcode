class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int sec = -1;

        for(int i = 0;i<n;i++){
            if(nums[i] == target){
                if(first == -1)first = i;
                sec = i;
            }
        }
        return new int[]{first,sec};
    }
}