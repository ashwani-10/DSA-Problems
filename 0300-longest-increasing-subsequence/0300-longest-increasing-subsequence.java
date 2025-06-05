class Solution {
    int [][] dp;
    public int helper(int[] nums,int idx,int pi){
        if(idx == nums.length) return 0;

        if(dp[idx][pi+1] != -1) return dp[idx][pi+1];

        int notTake = helper(nums,idx+1,pi);

        int take = 0;
        if(pi == -1 || nums[idx] > nums[pi]){
            take = 1 + helper(nums,idx+1,idx);
        }

        return dp[idx][pi+1] = Math.max(take,notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);

        int res = helper(nums,0,-1);
        return res;
    }
}