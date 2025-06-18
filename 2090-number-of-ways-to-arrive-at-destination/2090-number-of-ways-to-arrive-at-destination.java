class Solution {
    List<List<Integer>> res;
    final int MOD = 1_000_000_007;
    static class Pair{
        int dest;
        int time;
        Pair(int dest,int time){
            this.dest = dest;
            this.time = time;
        }
    }
    public void dfs(int node,int dest,List<List<Pair>> adj,List<Integer> path,boolean[] vis){
        path.add(node);
        if(node == dest){
            res.add(new ArrayList<>(path));
        }else{
            vis[node] = true;

            for(Pair nb : adj.get(node)){
                if(!vis[nb.dest])
                dfs(nb.dest,dest,adj,path,vis);
            }
            vis[node] = false;
        }
        path.remove(path.size()-1);
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int t = road[2];

            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)-> p1.time-p2.time);
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curr = p.dest;
            int time = p.time;

            if(time > dist[curr]) continue;

            for(Pair nb : adj.get(curr)){
                int v = nb.dest;
                int nbTime = nb.time;

                if(dist[v] > dist[curr] + nbTime){
                    dist[v] = dist[curr] + nbTime;
                    ways[v] = ways[curr];
                    pq.add(new Pair(v,(int) dist[v]));
                } else if(dist[v] == dist[curr] + nbTime){
                    ways[v] = (ways[v] + ways[curr]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}