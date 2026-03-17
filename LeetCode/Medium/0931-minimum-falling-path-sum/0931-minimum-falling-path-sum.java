class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int prev[] = new int[n];
        for(int j = 0;j<n;j++){
           prev[j] = matrix[0][j];
        }
        for(int i = 1;i<n;i++){
            int cur[] = new int[n];
            for(int j = 0;j<n;j++){
                int up = matrix[i][j] + prev[j];
                int left = matrix[i][j];
                if(j > 0){
                    left += prev[j-1];
                }
                else{
                    left += (int)1e9;
                }
                int right = matrix[i][j];
                if(j < n-1){
                    right += prev[j+1];
                }
                else{
                    right += (int)1e9;
                }
                cur[j] = Math.min(up,Math.min(right,left));
            }
            prev = cur;
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<n;j++){
            min = Math.min(min,prev[j]);
        }
        return min;
    }
}