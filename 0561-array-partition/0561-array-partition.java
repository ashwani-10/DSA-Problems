class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int maxSum = 0;

        for(int i=0;i<n;i = i+2){
            maxSum += nums[i];
        }

        return maxSum;

    }
}