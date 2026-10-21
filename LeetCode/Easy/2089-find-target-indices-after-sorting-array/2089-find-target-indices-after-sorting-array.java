class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        for(int num : nums){
            if(num == target){
                ans.add(idx);
            }
            idx++;
        }

        return ans;
    }
}