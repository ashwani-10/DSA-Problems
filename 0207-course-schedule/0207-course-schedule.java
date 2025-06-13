// If current node is visited but not in the path that i am coming from then
// it is not a cycle in that path for directed graph 
// and if it is part of my current path then it is a cycle

class Solution {
    public boolean isCycle(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pVis){
        visited[node] = true;
        pVis[node] = true;

        for(int nb : adj.get(node)){
            if(!visited[nb]){
                if(isCycle(nb,adj,visited,pVis)) return true;
            } else if(pVis[nb]) return true;
        }

        pVis[node] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u); // u dependes on v
        }

        // boolean[] visited = new boolean[n];
        // boolean[] pVis = new boolean[n];

        // for(int i=0;i<n;i++){
        //     if(isCycle(i,adj,visited,pVis)) return false;
        // }
        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int node = q.remove();

            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.add(it);
                    count++;
                }
            }
        }

        return count == n ? true : false;

    }
}