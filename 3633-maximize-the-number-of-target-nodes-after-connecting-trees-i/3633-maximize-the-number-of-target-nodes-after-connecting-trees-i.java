class Solution {
    public int dfs(List<List<Integer>> adj,int k,int node,int nodeParent){
        if(k<0) return 0;
        
        int count = 1;

        for(int nb : adj.get(node)){
            if(nb != nodeParent){
                count += dfs(adj,k-1,nb,node);
            }
        }

        return count;
    }

    public void findCount(int[][] edges1,int[] res, int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<edges1.length+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges1.length;i++){
            int u = edges1[i][0];
            int v = edges1[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<res.length;i++){
            res[i] += dfs(adj,k,i,-1);
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        
        int[] res1 = new int[edges1.length+1];
        int[] res2 = new int[edges2.length+1];

        findCount(edges1,res1,k);
        findCount(edges2,res2,k-1);

        int maxVal = -1;
        for(int num : res2){
            maxVal = Math.max(maxVal,num);
        }

        for(int i=0;i<res1.length;i++){
            res1[i] += maxVal;
        }

        return res1;
    }
}