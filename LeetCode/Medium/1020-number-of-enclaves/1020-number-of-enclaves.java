class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean visi[][] = new boolean[n][m];
        //top
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 1 && !visi[0][i]){
                dfs(grid,0,i,visi);
            }
        }
        //right
        for(int i = 1;i<n-1;i++){
            if(grid[i][m-1] == 1 && !visi[i][m-1]){
                dfs(grid,i,m-1,visi);
            }
        }
        //left
        for(int i = n-2;i>0;i--){
            if(grid[i][0] == 1 && !visi[i][0]){
                dfs(grid,i,0,visi);
            }
        }
        //bottom
        for(int i = m-1;i>=0;i--){
            if(grid[n-1][i] == 1 && !visi[n-1][i]){
                dfs(grid,n-1,i,visi);
            }
        }
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !visi[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int[][]grid,int i,int j,boolean visi[][]){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || visi[i][j]){
            return;
        }
        visi[i][j] = true;

        dfs(grid,i-1,j,visi);
        dfs(grid,i+1,j,visi);
        dfs(grid,i,j-1,visi);
        dfs(grid,i,j+1,visi);
    }
}