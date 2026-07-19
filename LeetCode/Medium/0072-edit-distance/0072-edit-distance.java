class Solution {
    int n;
    int m;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return sol(0,0,word1,word2,dp);    
    }

    int sol(int i, int j, String s1, String s2,int dp[][]){
        if(i == n)return dp[n][j] = m-j;
        if(j == m)return dp[i][m] = n-i;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = sol(i+1,j+1,s1,s2,dp);
        }
        int replace = sol(i+1,j+1,s1,s2,dp);
        int delete = sol(i+1,j,s1,s2,dp);
        int insert = sol(i,j+1,s1,s2,dp);

        return dp[i][j] = 1 + Math.min(replace,Math.min(insert,delete));
    }
}