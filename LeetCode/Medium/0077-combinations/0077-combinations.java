class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();
        sol(1,n,k,res,ans);
        return res;
    }

    void sol(int i,int n,int k,List<List<Integer>> res,List<Integer>ans){
        if(ans.size() == k){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int idx = i;idx<=n;idx++){
            ans.add(idx);
            sol(idx+1,n,k,res,ans);
            ans.remove(ans.size()-1);
        }
    }
}