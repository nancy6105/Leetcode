class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int max = 0;
        int start = -1;
        int end = -1;

        int dp[][] = new int[n][n];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(sol(i,j,s,dp)){
                    if(max < j-i+1){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

    boolean sol(int i,int j,String s,int dp[][]){
        if(i >= j){
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        if(s.charAt(i) == s.charAt(j)){
            boolean ans = sol(i+1, j-1, s, dp);
            dp[i][j] = (ans) ? 1 : 0;
            return ans;
        }
        else{
            dp[i][j] = 0;
            return false;
        }
    }
}