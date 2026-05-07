class Solution {
    class Pair{
        int stops;
        int node;
        int distance;

        public Pair(int stops,int node,int distance){
            this.stops = stops;
            this.node = node;
            this.distance = distance;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int flight[] : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            adj.get(u).add(new int[]{v,wt});
        }

        int dist[] = new int[n];

        for(int i = 0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,src,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int stop = p.stops;
            int np = p.node;
            int dp = p.distance;

            if(stop > k)continue;
            for(int[] it : adj.get(np)){
                int nei = it[0];
                int d = it[1];

                if(dp + d < dist[nei] && stop <= k){
                    dist[nei] = dp + d;
                    q.offer(new Pair(stop+1,nei,dp+d));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}