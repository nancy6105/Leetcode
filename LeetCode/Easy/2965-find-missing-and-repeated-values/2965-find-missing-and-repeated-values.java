class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int rep = -1;
        int mis = -1;
        int n = grid.length;

        for(int i = 1; i <= n*n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(grid[j][k] == i)cnt++;
                }
            }
            if(cnt == 2)rep = i;
            else if(cnt == 0)mis = i;

            if(mis != -1 && rep != -1)break;
        }

        return new int[]{rep,mis};
    }
}