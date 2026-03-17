class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return sol(0,0,m-1,grid,dp);
    }
    int sol(int i,int j1,int j2,int[][] a,int dp[][][]){
        int n = a.length;
        int m = a[0].length;

        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int)-1e9;
        }
        if(i == n-1){
            if(j1 == j2){
                return a[i][j1];
            }
            else{
                return a[i][j1] + a[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for(int d1 = -1; d1 <= 1; d1++){
            for(int d2 = -1; d2 <= 1; d2++){
                int value;

                if(j1 == j2){
                    value = a[i][j1];
                }
                else{
                    value = a[i][j1] + a[i][j2];
                }

                value += sol(i+1,j1+d1,j2+d2,a,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}