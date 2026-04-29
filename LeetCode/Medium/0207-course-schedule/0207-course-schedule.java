class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] num : prerequisites){
            int u = num[0];
            int v = num[1];

            adj.get(v).add(u);
        }

        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int nei : adj.get(i)){
                indegree[nei]++;
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){
            int n = q.poll();
            cnt++;

            for(int nei : adj.get(n)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        if(cnt == numCourses)return true;
        return false;
    }
}