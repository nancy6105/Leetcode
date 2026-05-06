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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if(n == 1 && m == 1)return 0;

        int dist[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.distance-b.distance);
        q.offer(new Pair(0,0,0));

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int diff = p.distance;
            int xp = p.x;
            int yp = p.y;

            if(xp == n-1 && yp == m-1)return diff;
            for(int i = 0;i<4;i++){
                int dx = xp + dr[i];
                int dy = yp + dc[i];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m){
                    int newDiff = Math.max(Math.abs(heights[xp][yp] - heights[dx][dy]),diff);

                    if(newDiff < dist[dx][dy]){
                        dist[dx][dy] = newDiff;
                        q.offer(new Pair(newDiff,dx,dy));
                    }
                }
            }
        }
        return 0;
    }
}