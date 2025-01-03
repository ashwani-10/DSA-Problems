class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] pSum = new long[n];
        pSum[0] = nums[0];

        for(int i=1;i<n;i++){
            pSum[i] = nums[i] + pSum[i-1];
        }
        int count = 0;

        for(int i=0;i<n-1;i++){
            if(pSum[i] >= pSum[n-1]-pSum[i])
            count++;
        }
        return count;
    }
}