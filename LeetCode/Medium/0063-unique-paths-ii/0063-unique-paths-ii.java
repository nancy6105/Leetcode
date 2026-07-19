class Solution {
    int n;
    int m;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(n-1,m-1,obstacleGrid,dp);
    }
    int sol(int i,int j,int[][] arr,int dp[][]){
        if(i >= 0 && j >= 0 && arr[i][j] == 1){
            return 0;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }

        if(i == 0 && j == 0){
            return 1;
        }
        

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = sol(i-1,j,arr,dp);
        int left = sol(i,j-1,arr,dp);
        return dp[i][j] = up+left;
    }
}