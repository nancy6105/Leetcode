class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[n*m];
        int k = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[k++] = grid[i][j]; 
            }
        }
        Arrays.sort(arr);
        int median = (n*m)/2;

        int target = arr[median];

        int cnt = 0;

        for(int i = 0;i<n*m;i++){
            if((target-arr[i]) % x != 0){
                return -1;
            }
            cnt += Math.abs(arr[i] - target) / x;
        }
        return cnt;
    }
}