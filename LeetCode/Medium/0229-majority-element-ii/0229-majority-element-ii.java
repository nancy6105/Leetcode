class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == nums[i]){
                    cnt++;
                }
            }

            if(cnt > n/3 && !res.contains(nums[i])){
                res.add(nums[i]);
            }
        }
        return res;
    }
}