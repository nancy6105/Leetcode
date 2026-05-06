class Solution {
    class Pair{
        int distance;
        int x;
        int y;

        public Pair(int distance,int x,int y){
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1;
        if(n == 1 && m == 1)return 1;
        int dist[][] = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1,0,0));
        int dr[] = {-1,+1,0,0,-1,-1,+1,+1};
        int dc[] = {0,0,-1,+1,-1,+1,-1,+1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int dp = p.distance;
            int xp = p.x;
            int yp = p.y;

            for(int i = 0;i<8;i++){
                int dx = xp + dr[i];
                int dy = yp + dc[i];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && grid[dx][dy] == 0){
                    if(dist[dx][dy] > dp + 1){
                        dist[dx][dy] = dp + 1;
                        if(dx == n-1 && dy == m-1)return dp + 1;
                        q.offer(new Pair(dp + 1,dx,dy));
                    }
                }
            }
        }
        return -1;
    }
}