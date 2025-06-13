class Solution {
    public boolean isCycle(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pVis){
        visited[node] = true;
        pVis[node] = true;

        for(int nb : adj.get(node)){
            if(!visited[nb]){
                if(isCycle(nb,adj,visited,pVis)) return true;
            } else if(pVis[nb]) return true;
        }

        pVis[node] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[n];
        boolean[] pVis = new boolean[n];

        for(int i=0;i<n;i++){
            if(isCycle(i,adj,visited,pVis)) return false;
        }

        return true;
    }
}