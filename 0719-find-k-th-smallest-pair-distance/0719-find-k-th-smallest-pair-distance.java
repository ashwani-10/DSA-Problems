class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left=0, right=nums[n-1]-nums[0], cnt, m, i, j;
        while (left<right){
            m = (left+right)/2;
            cnt = 0;
            for (i=0,j=0; i<n; i++){
                while (j<n && nums[j]<=nums[i]+m) j++;
                cnt += j-i-1;
            }
            if (cnt<k){
                left = m+1;
            }else{
                right = m;
            }
        }
        return left;
    }
}