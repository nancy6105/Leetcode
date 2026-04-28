class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int org = image[sr][sc];

        if(image[sr][sc] == color)return image;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));

        image[sr][sc] = color;
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;

            for(int k = 0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == org){
                    image[nr][nc] = color;
                    q.offer(new Pair(nr,nc));
                }
            } 
        }
        return image;

    }
}