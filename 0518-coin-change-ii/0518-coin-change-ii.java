class Solution {
    int[][]dp;
    public int helper(int n,int[] coins, int amount){
        if(amount == 0) return 1;
        if(n==0) return 0;

        if(dp[n][amount] != -1) return dp[n][amount];

        if(coins[n-1] <= amount){
            return dp[n][amount] = helper(n,coins,amount-coins[n-1])+helper(n-1,coins,amount);
        }
        return dp[n][amount] = helper(n-1,coins,amount);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n,coins,amount);
    }
}