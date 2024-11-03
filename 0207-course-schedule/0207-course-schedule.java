class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            
            adj.get(u).add(v);
        }
        
        int indegre[] = new int[n];
        
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegre[it]++;
            }
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegre[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int it : adj.get(node)){
                indegre[it]--;
                
                if(indegre[it] == 0){
                    q.add(it);
                    count++;
                }
            }
        }
        return count == n ? true : false;
    }
}