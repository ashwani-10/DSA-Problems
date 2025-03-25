class Solution {
    Boolean dp[][];
    public boolean helper(int n,int sum,int[] nums){
        if(sum == 0) return true;
        if(n == 0) return false;

        if(dp[n][sum] != null) return dp[n][sum];

        if(nums[n-1] <= sum){
            return dp[n][sum] = helper(n-1,sum-nums[n-1],nums) || helper(n-1,sum,nums);
        }

        return dp[n][sum] = helper(n-1,sum,nums);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum%2 != 0){
            return false;
        }

        dp = new Boolean[n+1][sum+1];

        return helper(n,sum/2,nums);
    }
}