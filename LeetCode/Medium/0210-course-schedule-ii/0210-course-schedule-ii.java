class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int indegree[] = new int[V];

        for(int i = 0;i<V;i++){
            for(int nei : adj.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int topo[] = new int[V];
        int cnt = 0;
        int i = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            cnt++;

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        if(cnt == V){
            return topo;
        }
        return new int[]{};
    }
}