class Solution {
    int n;
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return sol(0,n-1,s,dp);
    }
    int sol(int i,int j,String s,int dp[][]){
        if(i > j){
            return 0;
        }
        if(i == j){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + sol(i+1,j-1,s,dp);
        }

        return dp[i][j] = Math.max(sol(i+1,j,s,dp),sol(i,j-1,s,dp));
    }
}