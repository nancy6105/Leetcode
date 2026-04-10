class Solution {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        res =  Math.min(res,2*(k-i));
                    }
                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
    }
}