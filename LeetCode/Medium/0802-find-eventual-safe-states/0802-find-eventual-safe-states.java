class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        boolean visi[] = new boolean[V];
        boolean pathvisi[] = new boolean[V];
        boolean check[] = new boolean[V];

        for(int i = 0;i<V;i++){
            if(!visi[i]){
                check(graph,i,visi,pathvisi,check);
            }
        }
        List<Integer>res = new ArrayList<>();
        for(int i = 0;i<V;i++){
            if(check[i])res.add(i);
        }
        return res;
    }
    boolean check(int [][]graph,int n,boolean visi[],boolean pathvisi[],boolean check[]){
        visi[n] = true;
        pathvisi[n] = true;

        for(int nei : graph[n]){
            if(!visi[nei]){
                if(check(graph,nei,visi,pathvisi,check)){
                    return true;
                }
            }
            else if(pathvisi[nei]){
                return true;
            }
        }
        check[n] = true;
        pathvisi[n] = false;
        return false;
    }
}