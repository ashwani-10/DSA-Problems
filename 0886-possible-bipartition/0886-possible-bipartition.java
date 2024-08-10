class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int node,int vis[],int c){
        vis[node] = c;

        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(adj,it,vis,-1*c) == false) return false;
            }
            else{
                if(vis[it] == c) return false;
            }
        }
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Integer>());

        for(int i = 0; i<dislikes.length; i++){ // O(E)
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int vis [] = new int[n+1];
        for(int i=1 ; i<=n; i++){
            if(vis[i] == 0){
                if(dfs(adj,i,vis,1) == false) return false;
            }
        }
        return true;
    }
}