class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        
        int dp[][] = new int[i+1][j+1];
        for(int n = 0;n<i;n++){
            Arrays.fill(dp[n],-1);
        }
        return sol(i-1,j-1,text1,text2,dp);
    }

    int sol(int i,int j,String s1,String s2,int dp[][]){
        if(i < 0 ||j < 0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + sol(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = 0 + Math.max(sol(i-1,j,s1,s2,dp),sol(i,j-1,s1,s2,dp));
    }
}