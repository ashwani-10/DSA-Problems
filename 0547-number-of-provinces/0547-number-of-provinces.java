class Solution {
    public void dfs(int[] vis,int node,List<List<Integer>> adj){
        vis[node] = 1;

        for(int nb : adj.get(node)){
            if(vis[nb] == 0){
                dfs(vis,nb,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        int province = 0;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                province++;
                dfs(vis,i,adj);
            }    
        }

        return province;
    }
}