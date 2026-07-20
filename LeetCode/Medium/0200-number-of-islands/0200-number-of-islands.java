class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visi = new boolean [n][m];
        int cnt = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visi[i][j]){
                    bfs(grid,i,j,visi);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void bfs(char[][] grid,int i,int j,boolean [][] visi){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        visi[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.x;
            int col = p.y;

            for(int k = 0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1' && !visi[nr][nc]){
                    visi[nr][nc] = true;
                    q.offer(new Pair(nr,nc));
                }
            }
        } 
    }
}