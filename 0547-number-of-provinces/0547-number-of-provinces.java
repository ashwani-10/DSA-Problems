class Solution {
    public void dfs(int node,int[][] isConnected,int[] vis){
        vis[node] = 1;
        
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && vis[i] == 0){
                dfs(i,isConnected,vis);
            } 
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                
                while(!q.isEmpty()){
                    int node = q.remove();
                    
                    for(int k=0;k<isConnected.length;k++){
                        if(isConnected[node][k] == 1 && vis[k] == 0){
                            vis[k] = 1;
                            q.add(k);
                        } 
                    }
                }
            }
        }
        return count;
    }
}