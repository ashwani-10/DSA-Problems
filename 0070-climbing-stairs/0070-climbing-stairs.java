class Solution {
    int dp[];
    public int helper(int n){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        return dp[n] = helper(n-1) + helper(n-2);
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int maxVal = helper(n);
        return maxVal;
    }
}