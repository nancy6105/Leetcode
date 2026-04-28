class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int org = image[sr][sc];

        if(org == color) return image;

        dfs(image,sr,sc,org,color);
        return image;
    }
    void dfs(int [][]image,int i,int j,int org,int color){
        int n = image.length;
        int m = image[0].length;
        
        if(i < 0 || j < 0 || i >= n || j >= m || image[i][j] != org){
            return;
        }

        image[i][j] = color;
        dfs(image,i-1,j,org,color);
        dfs(image,i+1,j,org,color);
        dfs(image,i,j-1,org,color);
        dfs(image,i,j+1,org,color);

    }
}