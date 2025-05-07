class Solution {
    int n;
    public void dfs(int[] vis,int node,int[][] isConnected){
        vis[node] = 1;

        for(int nb=0;nb<n;nb++){
            if(isConnected[node][nb] == 1 & vis[nb] == 0){
                dfs(vis,nb,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int province = 0;

        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                province++;
                dfs(vis,i,isConnected);
            }    
        }

        return province;
    }
}