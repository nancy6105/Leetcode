class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        int res = 1;
        for(int i = 0;i<n;i++){
            res = Math.max(res,sol(i,arr,d,dp));
        }

        return res;
    }

    int sol(int i, int[] arr, int d,int dp[]){
        int n = arr.length;

        if(dp[i] != -1)return dp[i];
        
        int res = 1;

        for(int j = i-1; j >= Math.max(0,i-d); j--){
            if(arr[j] >= arr[i])break;
            res = Math.max(res,1 + sol(j,arr,d,dp));
        }

        for(int j = i+1; j <= Math.min(n-1,i+d); j++){
            if(arr[j] >= arr[i])break;
            res = Math.max(res,1 + sol(j,arr,d,dp));
        }
        return dp[i] = res;
    }
}