class Edge{
   int v;
   int wt;
   Edge(){

   }
   Edge(int v,int wt){
      this.v = v;
      this.wt = wt;
   }
}
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<N+1;i++){
         adj.add(new ArrayList<Edge>());
        }
        for(int i=0;i<times.length;i++){
         int u = times[i][0];
         int v = times[i][1];
         int wt = times[i][2];

         adj.get(u).add(new Edge(v,wt));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> (e1.wt-e2.wt));
        pq.add(new Edge(K,0));
        int vis[] = new int[N+1];
        Arrays.fill(vis,Integer.MAX_VALUE);

        vis[K] = 0;

        while(!pq.isEmpty()){
         Edge ed = pq.remove();

         for(Edge e : adj.get(ed.v)){
            int v = e.v;
            int wt = e.wt;

            if(vis[v] > ed.wt + e.wt){
            vis[v] = ed.wt + e.wt;
            pq.add(new Edge(v, vis[v]));
         }
        }

        
    }
    int maxi = 0;
        for(int i = 1; i <= N; i++){
            if(i != K && vis[i] == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi, vis[i]);
        }
        return maxi;
    }
}