class Solution {
    public boolean check(int[][] adj,int[] vis,int[] pvis,int node){
        vis[node] = 1;
        pvis[node] = 1;

        for(int num : adj[node]){
            if(vis[num] == 0 && check(adj,vis,pvis,num)){
                return true;
            }
            else if(pvis[num] == 1){
                return true;
            }
        }
        pvis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> res = new ArrayList();
        int [] vis = new int[V+1];
        int [] pvis = new int[V+1];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                check(graph, vis, pvis, i);
                }
            }
        for(int i=0;i<V;i++){
                if(pvis[i] == 0){
                    res.add(i);
                }
            }
            return res;
    }
}