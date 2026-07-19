class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int n = nums.length;
        int r = n-1 ;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
            if(nums[mid] == target){
                return mid;
            }
        }

        return l;
    }
}