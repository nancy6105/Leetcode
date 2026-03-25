class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;

        for(int r[] : grid){
            for(int i : r){
                total += i;
            }
        }

        if(total%2 != 0)return false;
        long target = total / 2;

        long sum = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<m;j++){
                sum += grid[i][j];
            }
            if(target == sum) return true;
        }

        sum = 0;

        for(int i = 0;i<m-1;i++){
            for(int j = 0;j<n;j++){
                sum += grid[j][i];
            }

            if(sum == target)return true;
        }

        return false;
    }
}