class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int layers = Math.min(n/2,m/2);

        while(layers-- > 0){
            int top = layers;
            int bottom = n-1-layers;
            int left = layers;
            int right = m-1-layers;

            ArrayList<Integer>arr = new ArrayList<>();
            //toprow 
            for(int j = left;j<=right;j++){
                arr.add(grid[top][j]);
            }

            //rightcolumn
            for(int j = top+1;j<=bottom-1;j++){
                arr.add(grid[j][right]);
            }

            //bottomrow
            for(int j = right;j>=left;j--){
                arr.add(grid[bottom][j]);
            }

            //leftcolumn
            for(int j = bottom-1;j>=top+1;j--){
                arr.add(grid[j][left]);
            }

            int len = arr.size();
            int nk = k%len;
            Collections.rotate(arr,-nk);

            int idx = 0;
            
            //toprow 
            for(int j = left;j<=right;j++){
                grid[top][j] = arr.get(idx++);
            }

            //rightcolumn
            for(int j = top+1;j<=bottom-1;j++){
                grid[j][right] = arr.get(idx++);
            }

            //bottomrow
            for(int j = right;j>=left;j--){
                grid[bottom][j] = arr.get(idx++);
            }

            //leftcolumn
            for(int j = bottom-1;j>=top+1;j--){
                grid[j][left] = arr.get(idx++);
            }
        }
        return grid;
    }
}