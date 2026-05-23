class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][] = new int[n][m];

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){

                if(i == n-1 && j == m-1){
                    dp[i][j] = grid[i][j];
                }

                else{
                    int down = (int)1e9;
                    int right = (int)1e9;

                    if(i+1 < n){
                        down = grid[i][j] + dp[i+1][j];
                    }
                    if(j+1 < m){
                        right = grid[i][j] + dp[i][j+1];
                    }

                    dp[i][j] = Math.min(right,down);
                }
            }
        }
        return dp[0][0];
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