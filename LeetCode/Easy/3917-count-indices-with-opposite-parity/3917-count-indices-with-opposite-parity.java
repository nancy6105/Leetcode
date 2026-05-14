class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;

        int res[] = new int[n];

        for(int i = 0;i < n; i++){
            if(nums[i]%2 == 0){
                int cnt = 0;
                for(int j = i+1; j < n; j++){
                    if(nums[j]%2 != 0){
                        cnt++;
                    }
                }
                res[i] = cnt;
            }

            else{
               int cnt = 0;
                for(int j = i+1; j < n; j++){
                    if(nums[j]%2 == 0){
                        cnt++;
                    }
                }
                res[i] = cnt; 
            }
        }

        return res;
    }
}