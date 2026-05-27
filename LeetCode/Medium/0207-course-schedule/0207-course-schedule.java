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

        int indegree[] = new int[v];
        for(int i = 0;i<v;i++){
            for(int nei : adj.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        if(topo.size() == v){
            return true;
        }
        return false;
    }
}