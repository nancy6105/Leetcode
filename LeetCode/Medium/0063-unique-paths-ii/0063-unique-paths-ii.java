class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1;j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == n-1 && j == m-1){
                    dp[i][j] = 1;
                }

                else{
                    int down = 0;
                    int right = 0;
                    if(i < n-1){
                        down = dp[i+1][j];
                    }
                    if(j < m-1){
                        right = dp[i][j+1]; 
                    }
                    dp[i][j] = down+right;
                }
            }
        }
        return dp[0][0];
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