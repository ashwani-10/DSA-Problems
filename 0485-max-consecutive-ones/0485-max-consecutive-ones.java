class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int res = 0;

        while(j<n){
            while(j < n && nums[j] == 1) j++;
            res = Math.max(res,j-i);
            j++;
            i = j;
        }
        return res;
    }
}