class Solution {
    int n;
    int m;
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(0,0,grid,dp);
    }
    int sol(int i,int j,int arr[][],int dp[][]){
        if(i >= n || j >= m){
            return (int)1e9;
        }
        if(i == n-1 && j == m-1){
            return arr[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = arr[i][j] + sol(i+1,j,arr,dp);
        int right = arr[i][j] + sol(i,j+1,arr,dp);
        return dp[i][j] = Math.min(down,right);
    }
}