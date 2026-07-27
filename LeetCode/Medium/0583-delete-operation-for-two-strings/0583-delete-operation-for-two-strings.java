class Solution {
    int n;
    int m;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int lcs = sol(0,0,word1,word2,dp);
        return (n - lcs) + (m - lcs);
    }
    int sol(int i,int j,String s1,String s2,int dp[][]){
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + sol(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(sol(i,j+1,s1,s2,dp),sol(i+1,j,s1,s2,dp));
    }
}