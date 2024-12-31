class Solution {
    int t[] = new int[366];
    public int solve(int[] days, int[] costs,int n,int i){
        if(i>=n)
        return 0;

        if(t[i] != -1) return t[i];
        //1 day pass
        int cost_1 = costs[0] + solve(days,costs,n,i+1);

        //7 day pass
        int maxDays = days[i] + 7;
        int j = i;

        while(j < n && days[j] < maxDays){
            j++;
        }

        int cost_7 = costs[1] + solve(days,costs,n,j);

        //30 day pass
        maxDays = days[i] + 30;
        j = i;

        while(j < n && days[j] < maxDays){
            j++;
        }

        int cost_30 = costs[2] + solve(days,costs,n,j);

        return t[i] = Math.min(Math.min(cost_1,cost_7),cost_30);

    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Arrays.fill(t,-1);
        return solve(days,costs,n,0);
    }
}