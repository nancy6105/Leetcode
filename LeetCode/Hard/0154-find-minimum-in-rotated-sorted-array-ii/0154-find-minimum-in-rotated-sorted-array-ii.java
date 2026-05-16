class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int n = nums.length;
        int j = n-1;
        

        return checkSorted(i,j,nums);
    }
    public int checkSorted(int i,int j,int nums[]){
        if(i == j)return nums[i];
        if(nums[i]<nums[j]){
            return nums[i];
        }
        int m = (i+j)>>1;

        return Math.min(checkSorted(i,m,nums), checkSorted(m+1,j,nums));
    }
}