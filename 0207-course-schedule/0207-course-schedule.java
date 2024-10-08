class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,int[] vis,int[] pvis,int node){
        vis[node] = 1;
        pvis[node] = 1;

        for(int num : adj.get(node)){
            if(vis[num] == 0 && isCycle(adj,vis,pvis,num)){
                return true;
            }
            else if(pvis[num] == 1){
                return true;
            }
        }
        pvis[node] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites){
        int []vis = new int[numCourses];
        int []pvis = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList(); 

       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<Integer>());
       }

       for(int i=0;i<prerequisites.length;i++){
        int u = prerequisites[i][0];
        int v = prerequisites[i][1];

        adj.get(v).add(u);
       }

       for(int i=0;i<numCourses;i++){
        if(vis[i] == 0 && isCycle(adj,vis,pvis,i)){
            return false;
        }

       }

       return true;
    }
}
