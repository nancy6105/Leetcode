class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return nums.length;
        }

        int cnt = 1;
        int k = 1;

        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]){
                cnt++;
            }

            else{
                cnt = 1; 
            }

            if(cnt <= 2){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}