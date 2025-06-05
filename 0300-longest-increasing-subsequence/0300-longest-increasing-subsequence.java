class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int maxi = 0;

        for(int i=0;i<n;i++){
            int len = maxLenWithIdx(nums,i);
            maxi = Math.max(maxi,len);
        }
        return maxi;
    }
    
    public int maxLenWithIdx(int [] nums,int idx){
        if(dp[idx] != -1) return dp[idx];

        int max = 0;
        for(int i = idx-1; i>=0; i--){
            if(nums[i] < nums[idx]){
                int len = maxLenWithIdx(nums,i);
                max = Math.max(max,len);
            }
        }
        return dp[idx] = max + 1;
    }
}