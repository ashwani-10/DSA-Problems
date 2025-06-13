class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            adj.get(v).add(u); // u dependes on v
        }

        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] res = new int[n];
        int i = 0;

        while(!q.isEmpty()){
            int node = q.remove();
            res[i++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0) q.add(it);
            }
        }

        if(i != n) return new int[0];

        return res;
    }
}