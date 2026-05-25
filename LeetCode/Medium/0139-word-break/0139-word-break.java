class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        return sol(0,s,st,dp);
    }

    boolean sol(int idx, String s, HashSet<String>st, int dp[]){
        
        int n = s.length();
        if(idx == n){
            return true;
        }
        if(dp[idx] != -1){
            return dp[idx] == 1;
        }
    
        for(int l = idx; l < n; l++){
            String sub = s.substring(idx,l+1);
            if(st.contains(sub)){
                if(sol(l + 1,s,st,dp)){
                    dp[idx] = 1;
                    return true;
                }
            }
        }
        dp[idx] = 0;
        return false;
    }
}