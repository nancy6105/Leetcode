class Solution {
    public int smallestIndex(int[] nums) {
        int ans = -1;
        for(int i = 0;i < nums.length; i++){
            if(i == sum(nums[i])){
                ans = i;
                break;
            }
        }

        return ans;
    }

    int sum(int n){
        int sum = 0;

        while(n != 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}