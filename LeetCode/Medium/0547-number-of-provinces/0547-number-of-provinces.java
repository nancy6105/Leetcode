class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean visited[] = new boolean[v];
        int cnt = 0;
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                cnt++;
                dfs(i,visited,isConnected);
            }
        }
        return cnt;
    }
    void dfs(int node,boolean visited[],int adj[][]){
        visited[node] = true;
        for(int i = 0;i<adj.length;i++){
            if(adj[node][i] == 1 && !visited[i]){
                dfs(i,visited,adj);
            }
        }
    }
}