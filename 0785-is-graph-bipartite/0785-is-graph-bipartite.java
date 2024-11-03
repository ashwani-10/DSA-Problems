class Solution {
    public boolean dfs(int[][] graph,int node,int[] color,int curColor){
    color[node] = curColor;

    for(int it : graph[node]){
        if(color[it] == color[node]) return false;

        if(color[it] == -1){
            color[it] = 1-color[node];
            if(!dfs(graph,it,color,color[it])) return false;
        }
    }
    return true;
    }
    public boolean isBipartite(int[][] graph) {

        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        // 1--> Red , 0--> Green

        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                if(!dfs(graph,i,color,1))
                return false;
            }
        }
        return true;
    }
}