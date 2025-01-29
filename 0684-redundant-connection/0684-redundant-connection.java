class Solution {
    int n;
    public boolean bfs(Map<Integer,ArrayList<Integer>> map,int u, int v){
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(u);

        while(!q.isEmpty()){
            int curr = q.remove();
            vis[curr] = true;
            if (curr == v) return true;
            
            for (int x : map.get(curr)) {
                if (!vis[x]) {
                    q.add(x);
                }
            }
        }
        return false;
        }
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(map.containsKey(u) && map.containsKey(v) && bfs(map,u,v)){
                return edges[i];
            }

            map.putIfAbsent(u,new ArrayList());
            map.putIfAbsent(v,new ArrayList());
            map.get(u).add(v);
            map.get(v).add(u);
            
        }
        return new int[0];
    }
}