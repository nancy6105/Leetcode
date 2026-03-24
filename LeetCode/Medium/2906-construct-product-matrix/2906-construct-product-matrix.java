class Solution {
    int mod = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int idx = 0;
        int size = n*m;
        int arr[] = new int[size];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[idx++] = grid[i][j]%mod;
            }
        }


        int prefix[] = new int[size];
        int sufix[] = new int[size];

        prefix[0] = 1;
        for(int i = 1;i<size;i++){
            prefix[i] = (int)(1L*prefix[i-1] * arr[i-1])%mod; 
        }

        sufix[size-1] = 1;
        for(int i = size-2;i>=0;i--){
            sufix[i] = (int)(1L*sufix[i+1] * arr[i+1])%mod;
        }

        int ans[][] = new int[n][m];

        idx = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans[i][j] = (prefix[idx] * sufix[idx])%mod;
                idx++;
            }
        }

        return ans;
    }
}