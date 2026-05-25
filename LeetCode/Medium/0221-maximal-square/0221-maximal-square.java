class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n+1][m+1];
        
        int max = 0;
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    int right = dp[i][j+1];
                    int down = dp[i+1][j];
                    int diagonal = dp[i+1][j+1];

                    int ans = 1+ Math.min(right,Math.min(down,diagonal));
                    dp[i][j] = ans;
                    max = Math.max(ans,max);
                }
            }
        }
        return max*max;
    }
}