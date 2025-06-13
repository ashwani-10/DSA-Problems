class Solution {
    public boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,int dest){
        if(node == dest) return true;
        visited[node] = true;

        for(int nb : adj.get(node)){
            if(!visited[nb]){
                if(dfs(nb,adj,visited,dest)) return true;
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        
        return dfs(source,adj,visited,destination);
    }
}