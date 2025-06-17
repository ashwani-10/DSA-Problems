class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }

    public int helper(int[] nums, int goal) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

         
        while(right < n){
            sum += nums[right];

            while(sum > goal && left <= right){
                sum -= nums[left];
                left++;
            }

            count += right-left+1;

            right++;
        }
        return count;
    }
}