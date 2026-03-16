class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        for(int j = 0;j<m;j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        for(int i = m-2;i >= 0;i--){
            for(int j = i;j >= 0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }
        return dp[0][0]; 
    }
    int sol(List<List<Integer>> triangle,int i,int j,int dp[][]){
        if(i == triangle.size()-1){
            return triangle.get(triangle.size()-1).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + sol(triangle,i+1,j,dp);
        int diagonal = triangle.get(i).get(j) + sol(triangle,i+1,j+1,dp);

        return dp[i][j] = Math.min(down,diagonal);
    }
}