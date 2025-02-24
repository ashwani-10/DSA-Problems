class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Map<Integer,Integer> bobMap = new HashMap<>();
    int aliceIncome;

    boolean bobDfs(int curr,int t,boolean[] vis){
        vis[curr] = true;
        bobMap.put(curr,t);

        if(curr == 0){ // reached target for bob
            return true;
        }

        for(int ng : adj.getOrDefault(curr,new ArrayList<>())){
            if(!vis[ng]){
                if(bobDfs(ng,t+1,vis)){
                    return true;
                }
            }
        }

        bobMap.remove(curr);
        return false;
    }

    void aliceDfs(int curr,int t,int income,boolean[] vis,int[] amount){
        vis[curr] = true;

        if(!bobMap.containsKey(curr) || t < bobMap.get(curr)){
            income += amount[curr];
        }else if(t == bobMap.get(curr)){
            income += (amount[curr]/2);
        }

        if(adj.getOrDefault(curr,new ArrayList<>()).size() == 1 && curr != 0){
            aliceIncome = Math.max(aliceIncome,income);
        }

        for(int ng : adj.getOrDefault(curr,new ArrayList<>())){
            if(!vis[ng]){
                aliceDfs(ng,t+1,income,vis,amount);
            }
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        aliceIncome = Integer.MIN_VALUE;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k-> new ArrayList<>()).add(u);
        }

        int time = 0;
        boolean[] vis = new boolean[n];
        bobDfs(bob,time,vis);

        int income = 0;
        Arrays.fill(vis,false);
        aliceDfs(0,0,income,vis,amount);
        return aliceIncome;
    }
}