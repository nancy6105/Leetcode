class Solution {
    class Pair{
        int time;
        int node;
        public Pair(int time,int node){
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int time[] : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[]{v,wt});
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
        pq.offer(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dp = p.time;
            int np = p.node;

            for(int it[] : adj.get(np)){
                int nei = it[0];
                int d = it[1];

                if(dist[nei] > dp + d){
                    dist[nei] = dp + d;
                    pq.offer(new Pair(dp+d,nei));
                } 
            }
        }

        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE)return -1;
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}