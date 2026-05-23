class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][] = new int[n][m];

        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return sol(0,0,grid,dp);
    }
    public int sol(int i, int j, int[][]arr, int dp[][]){
        if(i == arr.length-1 && j == arr[0].length-1){
            return arr[i][j];
        }

        if(i >= arr.length || j >= arr[0].length){
            return (int)1e9;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int down = arr[i][j] + sol(i+1,j,arr,dp);
        int diagonal = arr[i][j] + sol(i,j+1,arr,dp);

        return dp[i][j] = Math.min(down,diagonal);
    }
}