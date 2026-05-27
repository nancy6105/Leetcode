class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();

        sol(0,candidates,target,res,ans);
        return res;
    }
    void sol(int idx,int nums[],int target,List<List<Integer>> res,List<Integer> ans){
        int n = nums.length;
        if(idx == n){
            if(target == 0){
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        if(nums[idx]<=target){
            ans.add(nums[idx]);
            sol(idx,nums,target-nums[idx],res,ans);
            ans.remove(ans.size()-1);
        }
        sol(idx+1,nums,target,res,ans);
    }
}