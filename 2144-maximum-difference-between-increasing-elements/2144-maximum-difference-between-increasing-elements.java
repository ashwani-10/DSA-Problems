class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int maxDif = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                maxDif = Math.max(maxDif,nums[j]-nums[i]);
            }
        }

        return maxDif == 0 ? -1:maxDif;
    }
}