class Solution {
    public int maxDistinctElements(int[] nums, int k) {
    int ans = 0;
    Arrays.sort(nums);
    int last = Integer.MIN_VALUE;
    for(int i = 0;i < nums.length; ++i){
        int mn = nums[i] - k;
        int mx = nums[i] + k;
        if(last < mn ) { last = mn; ans++; }
        else if(last < mx){ last = last + 1; ans++; }
    }
    return ans;
}
}