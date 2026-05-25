class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                String sub = s.substring(i,j+1); 
                if(st.contains(sub)){
                    if(dp[j+1] == 1){
                        dp[i] = 1;
                        break;
                    }
                }
            }
        }
        return dp[0] == 1;
    }
}