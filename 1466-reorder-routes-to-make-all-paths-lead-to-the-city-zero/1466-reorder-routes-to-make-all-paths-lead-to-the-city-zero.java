class Solution {
    public void dfs(int n,int node, int[][] connections,ArrayList<ArrayList<Integer>> forward,ArrayList<ArrayList<Integer>> backward,boolean[] vis,int[] ans){
        if(n==0) return;
        vis[node] = true;
        
        for(int num : forward.get(node)){
            if(vis[num] == false)
                ans[0]++;
                dfs(n,num,connections,forward,backward,vis,ans);
        }
        
        for(int num : backward.get(node)){
            if(vis[num] == false)
                dfs(n,num,connections,forward,backward,vis,ans);
        }
        
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> forward = new ArrayList();
        ArrayList<ArrayList<Integer>> backward = new ArrayList();
        boolean[] vis = new boolean[n];
        int[] ans = new int[1];
         for(int i=0;i<n;i++){
             forward.add(new ArrayList<Integer>());
             backward.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n-1;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            
            forward.get(u).add(v);
            backward.get(v).add(u);
        }
        
        dfs(n,0,connections,forward,backward,vis,ans);
        
        return ans[0];
    }
}