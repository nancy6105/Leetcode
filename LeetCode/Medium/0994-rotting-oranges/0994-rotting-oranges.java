class Solution {
    class Pair{
        int first;
        int second;
        int time;
        public Pair(int first,int second,int time){
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntfresh = 0;
        int visited[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1)cntfresh++;
            }
        }
        
        int tm = 0;
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        int cnt = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int t = p.time;
            tm = Math.max(tm,t);
            for(int k = 0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && visited[nr][nc] == 0){
                    q.offer(new Pair(nr,nc,t+1));
                    visited[nr][nc] = 2;
                    cnt++;
                }
            } 
        }
        if(cnt != cntfresh)return -1;
        return tm;
    }
}