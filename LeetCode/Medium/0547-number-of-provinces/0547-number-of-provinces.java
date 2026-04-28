class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = isConnected.length;
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<v;i++){
            for(int j = 0;j<v;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean visited[] = new boolean[v];
        int cnt = 0;
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                bfs(i,adj,visited);
                cnt++;
            }
        }
        return cnt;
    }
    void bfs(int n, ArrayList<ArrayList<Integer>>adj, boolean visited[]){
        visited[n] = true;
        Queue<Integer>q = new LinkedList<>();
        q.add(n);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
}