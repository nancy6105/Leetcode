class Solution {
    public int majorityElement(int[] nums) {
        //as freq shoult be > n/2 so it can not be possible that their might be multiple choices and the only element whose cnt is greater among all might be our answer

        int n = nums.length;
        int mightCnt = 0;
        int ele = -1;
        int i = 0;
        while(i < n){
            if(mightCnt == 0){
                mightCnt = 1;
                ele = nums[i];
            }

            else if(nums[i] == ele){
                mightCnt++;
            }
            else{
                mightCnt--;
            }
            i++;
        }

        int cnt = 0;
        for(int num : nums){
            if(num == ele){
                cnt++;
            }
        }
        if(cnt > n/2){
            return ele;
        }
        return -1;
    }
}