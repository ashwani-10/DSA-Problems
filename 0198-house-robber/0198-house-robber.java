class Solution {
    int dp[];
    public int helper(int i,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i]+helper(i+2,nums),helper(i+1,nums));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+2];
        Arrays.fill(dp,-1);
        int maxVal = helper(0,nums);
        return maxVal;
    }
}