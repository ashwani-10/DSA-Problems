class Solution {
    public int dominantIndex(int[] nums) {;
        int n = nums.length;
        if(n == 1) return 0;

        int largestIdx = 0;

        for(int i=1;i<n;i++){
            if(nums[i] > nums[largestIdx]){
                largestIdx = i;
            }
        }

        for(int i=0;i<n;i++){
            if(i != largestIdx && nums[i]*2 > nums[largestIdx]) return -1; 
        }

        return largestIdx;
    }
}