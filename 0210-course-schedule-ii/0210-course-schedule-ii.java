class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=1;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> pq = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i] == 0) pq.add(i);
        //BFS
        // ans array to store toposort
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            int node = pq.remove();
            ans.add(node);
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) pq.add(it);
            }
        }

        if(ans.size() == n){
            int []res = new int[n];
            for(int i=0;i<n;i++){
                res[i] = ans.get(i);
            }

            return res;
        }
        int [] res = new int[0];
        return res;
    }
}