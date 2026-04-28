class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int color[] = new int[v];
        Arrays.fill(color,-1);

        for(int i = 0;i<v;i++){
            if(color[i] == -1){
                if(!check(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean check(int n,int[][]g,int color[]){
        Queue<Integer>q = new LinkedList<>();
        q.offer(n);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : g[node]){
                if(color[nei] == -1){
                    color[nei] = 1-color[node];
                    q.offer(nei);
                }
                else if(color[nei] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}