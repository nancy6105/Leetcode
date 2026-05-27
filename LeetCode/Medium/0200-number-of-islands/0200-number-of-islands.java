class Solution {
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int cnt = 0;
        boolean visi[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visi[i][j]){
                    dfs(i,j,grid,visi);
                    cnt++;    
                }
            }
        }
        return cnt;
    }
    void dfs(int i,int j,char[][] grid,boolean visi[][]){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visi[i][j]){
            return;
        }
        visi[i][j] = true;
        dfs(i+1,j,grid,visi);
        dfs(i-1,j,grid,visi);
        dfs(i,j+1,grid,visi);
        dfs(i,j-1,grid,visi);
    }
}