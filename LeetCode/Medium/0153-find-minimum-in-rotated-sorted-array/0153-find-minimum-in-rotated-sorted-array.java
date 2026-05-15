class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int n = nums.length;
        int j = n-1;
        int ans = Integer.MAX_VALUE;

        while(i<=j){
            int mid = i + (j - i)/2;
            if(checkSorted(i,mid,nums)){
                ans = Math.min(nums[i],ans);
                i = mid + 1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                j = mid - 1;
            }
        }
        return ans;
    }
    public boolean checkSorted(int i,int j,int nums[]){
        if(nums[i]<=nums[j]){
            return true;
        }
        return false;
    }
}