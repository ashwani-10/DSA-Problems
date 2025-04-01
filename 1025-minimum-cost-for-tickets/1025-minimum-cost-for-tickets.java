class Solution {
    int dp[] = new int[366];
    public int solve(int[] days, int[] costs,int n,int i){
        if(i>=n)
        return 0;

        if(dp[i] != -1) return dp[i];

        int cost_1 = costs[0] + solve(days,costs,n,newIndex(i,days,days[i]+1));
        int cost_7 = costs[1] + solve(days,costs,n,newIndex(i,days,days[i]+7));
        int cost_30 = costs[2] + solve(days,costs,n,newIndex(i,days,days[i]+30));

        return dp[i] = Math.min(Math.min(cost_1,cost_7),cost_30);

    }
    public int newIndex(int curr,int days[],int targetDay){
        while(curr<days.length && days[curr] < targetDay){
            curr++;
        }
        return curr;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Arrays.fill(dp,-1);
        return solve(days,costs,n,0);
    }
}