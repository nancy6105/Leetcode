class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        int dp[][] = new int[101][101];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        int i = 0;
        int j = 0;
        
        return sol(i,j,s1,s2,s3,dp);
    }
    boolean sol(int i, int j, String s1, String s2, String s3,int dp[][]){
        int n = s1.length();
        int m = s2.length();
        int N = n+m;
        if(i == n && j == m){
            return true;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        boolean res = false;
        if(i < n && s1.charAt(i) == s3.charAt(i+j)){
            res = sol(i+1,j,s1,s2,s3,dp);
        }
        if(res){
            return res;
        }
        if(j < m && s2.charAt(j) == s3.charAt(i+j)){
            res = sol(i,j+1,s1,s2,s3,dp);
        }

        dp[i][j] = (res) ? 1 : 0;
        return res;
    }   
}