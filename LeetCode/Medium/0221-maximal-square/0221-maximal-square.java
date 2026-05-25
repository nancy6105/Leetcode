class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                max = Math.max(max,sol(i,j,matrix,dp));
            }
        }
        return max*max;
    }
    int sol(int i,int j, char[][] arr,int dp[][]){
        if(i >= arr.length || j >= arr[0].length){
            return 0;
        }

        if(arr[i][j] == '0'){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        
            int right = sol(i,j+1,arr,dp);
            int down = sol(i+1,j,arr,dp);
            int diagonal = sol(i+1,j+1,arr,dp);

            ans = 1 + Math.min(right,Math.min(down,diagonal));
        

        return dp[i][j] = ans;
    }
}