class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }
        int v = numCourses;
        int visi[] = new int[v];

        for(int i = 0;i<v;i++){
            if(visi[i] == 0){
                if(dfs(i,adj,visi)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int visi[]){

        if(visi[node] == 1){
            return true;
        }

        if(visi[node] == 2){
            return false;
        }

        visi[node] = 1;
        for(int nei : adj.get(node)){
            if(dfs(nei,adj,visi)){
                return true;
            }
        }
        visi[node] = 2;
        return false;
    }
}