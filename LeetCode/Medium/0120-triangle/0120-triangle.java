class Solution {
    int n;
    int m;
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        int dp[][] = new int[n][n];
        int next[] = new int[n];
        for(int i = 0;i<n;i++){
            next[i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i>=0;i--){
            int curr[] = new int[n];
            for(int j = 0;j<=i;j++){
                curr[j] = triangle.get(i).get(j) + Math.min(next[j],next[j+1]);
            }
            next = curr;
        }
        return next[0];
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