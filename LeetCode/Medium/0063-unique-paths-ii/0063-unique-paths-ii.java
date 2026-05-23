class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }
        return sol(0,0,obstacleGrid,dp);
    }
    int sol(int i,int j,int[][] arr,int dp[][]){
        int n = arr.length;
        int m = arr[0].length;
        if(i < n && j < m && arr[i][j] == 1){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(i >= n || j >= m)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int down = sol(i+1,j,arr,dp);
        int right = sol(i,j+1,arr,dp);
        return dp[i][j] = down + right;
    }
}