class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node] = 1;
        
        for(int num : adj.get(node)){
            if(vis[num] == 0)
                dfs(num,adj,vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        int count = 0;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}