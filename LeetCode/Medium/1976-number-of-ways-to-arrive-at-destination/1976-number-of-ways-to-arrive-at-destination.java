class Solution {
    class Pair{
        int node;
        long distance;
        public Pair(int node, long distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int src = 0;
        int dst = n-1;
        int mod = (int)(1e9 + 7);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : roads){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        int ways[] = new int[n];
        ways[src] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.distance, b.distance));
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int np = p.node;
            long dp = p.distance;

            for(int[] nei : adj.get(np)){
                int nein = nei[0];
                int neid = nei[1];

                if(dist[nein] > dp + neid){
                    dist[nein] = dp + neid;
                    pq.add(new Pair(nein,dp+neid));
                    ways[nein] = ways[np];
                }

                else if(dp + neid == dist[nein]){
                    ways[nein] = (ways[np] + ways[nein])%mod;
                }
            }
        }
        return ways[dst]%mod;
    }
}