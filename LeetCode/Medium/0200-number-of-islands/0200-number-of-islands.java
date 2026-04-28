class Solution {

    class Pair{
        int first;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid,i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void bfs(char[][]grid,int i,int j,boolean visited[][]){
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(i,j));
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1}; 
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;

            for(int k = 0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
    }
}