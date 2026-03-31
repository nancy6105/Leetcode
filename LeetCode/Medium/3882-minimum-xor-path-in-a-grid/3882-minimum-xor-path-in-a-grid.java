class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<Integer>[][]visited = new HashSet[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                visited[i][j] = new HashSet<>();
            }
        }

        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{0,0,grid[0][0]});
        visited[0][0].add(grid[0][0]);

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            int xor = curr[2];

            if(i == n-1 && j == m-1){
                min = Math.min(min,xor);
                continue;
            }

            if(j+1 < m){
                int newxor = xor ^ grid[i][j+1];
                if(!visited[i][j+1].contains(newxor)){
                    visited[i][j+1].add(newxor);
                    q.offer(new int[]{i,j+1,newxor});
                }
            }

            if(i+1 < n){
                int newxor = xor ^ grid[i+1][j];
                if(!visited[i+1][j].contains(newxor)){
                    visited[i+1][j].add(newxor);
                    q.offer(new int[]{i+1,j,newxor});
                }
            }
        }
        return min;
    }
}