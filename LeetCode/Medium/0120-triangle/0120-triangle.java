class Solution {
    int n;
    int m;
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        int dp[][] = new int[n][n];
        for(int j = 0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    int sol(int i, int j, List<List<Integer>> arr,int dp[][]){
        if(i == n-1){
            return arr.get(i).get(j);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = arr.get(i).get(j) + sol(i+1,j,arr,dp);
        int diag = arr.get(i).get(j) + sol(i+1,j+1,arr,dp);

        return dp[i][j] = Math.min(down,diag); 
    }
}