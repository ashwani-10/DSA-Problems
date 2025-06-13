class Solution {
    private List<List<Integer>> result;
    public void dfs(int node,int dest,int[][] graph,List<Integer> path){
        path.add(node);
        if(node == dest){
            result.add(new ArrayList<>(path));
            return;
        }else{
            for(int nb : graph[node]){
                dfs(nb,dest,graph,path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        result = new ArrayList<>();

        dfs(0,n-1,graph,new ArrayList<>());
        return result;
    }
}