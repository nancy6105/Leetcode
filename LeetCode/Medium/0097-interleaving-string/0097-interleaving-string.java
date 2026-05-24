class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        int dp[][][] = new int[101][101][201];
        for(int rows[][] : dp){
            for(int row[] : rows){
                Arrays.fill(row, -1);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        return sol(i,j,k,s1,s2,s3,dp);
    }
    boolean sol(int i, int j, int k, String s1, String s2, String s3,int dp[][][]){
        int n = s1.length();
        int m = s2.length();
        int N = n+m;
        if(i == n && j == m){
            return true;
        }

        if(dp[i][j][k] != -1){
            return dp[i][j][k] == 1;
        }

        boolean res = false;
        if(i < n && s1.charAt(i) == s3.charAt(k)){
            res = sol(i+1,j,k+1,s1,s2,s3,dp);
        }
        if(res){
            return res;
        }
        if(j < m && s2.charAt(j) == s3.charAt(k)){
            res = sol(i,j+1,k+1,s1,s2,s3,dp);
        }

        dp[i][j][k] = (res) ? 1 : 0;
        return res;
    }
}