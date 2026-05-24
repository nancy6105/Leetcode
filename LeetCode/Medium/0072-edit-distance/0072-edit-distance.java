class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return sol(0,0,word1,word2,dp);
    }
    int sol(int i, int j, String s1, String s2,int dp[][]){
        if(i == s1.length())return s2.length()-j;
        if(j == s2.length())return s1.length()-i;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return sol(i+1,j+1,s1,s2,dp);
        }

        int replace = sol(i + 1, j + 1,s1, s2,dp);
        int delete = sol(i + 1, j,s1, s2,dp);
        int insert = sol(i, j + 1,s1, s2,dp);

        return dp[i][j] = 1 + Math.min(replace,Math.min(delete,insert));

    }
}