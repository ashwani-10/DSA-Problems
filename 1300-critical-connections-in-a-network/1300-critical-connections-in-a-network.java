class Solution {
    private int time = 0;
    private List<List<Integer>> res;
    public void dfs(int u,int parent,List<List<Integer>> adj,int[] disc,int[] low){
        disc[u] = low[u] = time++;

        for(int v : adj.get(u)){
            if(v == parent) continue;

            if(disc[v] == -1){
                dfs(v,u,adj,disc,low);
                low[u] = Math.min(low[u],low[v]);

                //Bridge connection
                if(low[v] > disc[u]){
                    res.add(Arrays.asList(u,v));
                }
            }else{
                //Back edge
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

            int[] disc = new int[n];
            int[] low = new int[n];
            Arrays.fill(disc,-1);

            res = new ArrayList<>();

            dfs(0,-1,adj,disc,low);

            return res;
        }
}