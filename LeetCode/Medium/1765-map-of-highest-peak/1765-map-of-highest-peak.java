class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int res[][] = new int[n][m];
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(isWater[i][j] == 1){
                    q.offer(new Pair(i,j));
                    res[i][j] = 0;
                }
                else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.first;
            int j = p.second;

            for(int k = 0;k<4;k++){
                int row = i + dr[k];
                int col = j + dc[k];

                if(row >= 0 && col >= 0 && row < n && col < m && res[row][col] > res[i][j] + 1){
                    res[row][col] = res[i][j] + 1;
                    q.offer(new Pair(row,col));
                }
            }
        }
        return res;
    }
}