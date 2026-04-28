class Solution {
    class Pair{
        int r;
        int c;

        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dist[][] = new int[n][m];
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j));
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for(int k = 0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nc < m && nr < n && dist[nr][nc] > dist[row][col] + 1){
                    dist[nr][nc] = dist[row][col] + 1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
        return dist;
    }
}