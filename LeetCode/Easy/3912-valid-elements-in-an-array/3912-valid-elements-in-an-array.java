class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int rightmax[] = new int[nums.length];
        rightmax[n-1] = nums[n-1];
        int max = nums[n-1];
        for(int i = n-2;i>=0;i--){
            max = Math.max(nums[i],max);
            rightmax[i] = max;
        }
        res.add(nums[0]);
        int curr = nums[0];
        for(int i = 1;i<n-1;i++){
            if((nums[i] > curr) || (nums[i] > rightmax[i+1])){
                res.add(nums[i]);
            }
            curr = Math.max(nums[i],curr);
        }

        if(n > 1){
            res.add(nums[n-1]);
        }
        return res;
    }
}