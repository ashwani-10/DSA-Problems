class Solution {
    int res = -1;
    public void dfs(int[] edges,int node,int[] vis,int[] pvis,int[] count){
        vis[node] = 1;
        pvis[node] = 1;
        
        int v = edges[node];
        
        if(v != -1 && vis[v] == 0){
            count[v] += count[node];
            dfs(edges,v,vis,pvis,count);
        }
        else if(v != -1 && pvis[v] == 1){
            res = Math.max(res,count[node]-count[v]+1);
        }
        pvis[node] = 0;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int vis[] = new int[n];
        int pvis[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(count,1);
        
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(edges,i,vis,pvis,count);
            }
        }
        return res;
    }
}