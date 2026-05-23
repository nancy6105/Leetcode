class Solution {
    public boolean check(int[] nums) {
       int pivot = getPivot(nums);
       if(pivot == -1){
        return true;
       }
        boolean left = checkSorted(nums, 0, pivot);
        boolean right = checkSorted(nums, pivot+1, nums.length-1);

        return left && right && nums[nums.length-1] <= nums[0];
    }

    int getPivot(int nums[]){
        int pivot = -1;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    boolean checkSorted(int nums[], int start, int end){
        for(int i = start; i < end; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}