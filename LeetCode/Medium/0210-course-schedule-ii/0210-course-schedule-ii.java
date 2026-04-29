class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        ArrayList<Integer>res = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.poll();
            res.add(n);

            for(int nei : adj.get(n)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        int ans[] = new int[numCourses];
        if(res.size() < numCourses){
            return new int[]{};
        }
        for(int i = 0;i<numCourses;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}