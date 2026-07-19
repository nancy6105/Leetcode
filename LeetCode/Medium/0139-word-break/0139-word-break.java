class Solution {
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return sol(0,s,st,dp);
    }
    boolean sol(int idx,String s,HashSet<String>st,int dp[]){

        if(idx == n){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1;
        }
        for(int i = idx;i < n;i++){
            String sub = s.substring(idx,i+1);
            if(st.contains(sub)){
                if(sol(i+1,s,st,dp)){
                    dp[idx] = 1;
                    return true;
                }
            }
        }
        dp[idx] = 0;
        return false;
    }
    
}