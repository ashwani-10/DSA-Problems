class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int minValue = Integer.MAX_VALUE;
        int maxDif = 0;

        for(int i=0;i<n;i++){
            minValue = Math.min(minValue,nums[i]);
            maxDif = Math.max(maxDif,nums[i]-minValue);
        }

        return maxDif == 0 ? -1:maxDif;
    }
}