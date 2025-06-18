class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        int left = 0,right = 0;
        int sum = 0;
        while(right < n){
            sum += nums[right];
            while(left<=right && sum > k){
                sum -= nums[left];
                left++;
            }
            if(sum == k) maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
}

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;
        int len = maxSubArrayLen(nums,sum-x);

        return len == 0 && x!=sum ? -1 : n-len;
    }
}