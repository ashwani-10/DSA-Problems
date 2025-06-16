class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int[] rMax = new int[n];
        rMax[n-1] = nums[n-1];

        for(int i=n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1],nums[i]);
        }

        int maxDif = 0;

        for(int i=0;i<n;i++){
            maxDif = Math.max(maxDif,rMax[i]-nums[i]);
        }

        return maxDif == 0 ? -1:maxDif;
    }
}