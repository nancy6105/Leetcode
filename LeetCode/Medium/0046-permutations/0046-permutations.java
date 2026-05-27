class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        sol(nums,res,ans);
        return res;
    }
    void sol(int[] nums,List<List<Integer>>res,List<Integer>ans){
        int n = nums.length;
        if(ans.size() == n){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0;i<n;i++){
            if(ans.contains(nums[i]))continue;
            ans.add(nums[i]);
            sol(nums,res,ans);
            ans.remove(ans.size()-1);
        }
    }
}