class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        int i=0;
        int j=0;
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        HashSet set = new HashSet<>();
        
        while(j<n){
           while(set.contains(nums[j])){
               sum -= nums[i];
               set.remove(nums[i]);
               i++;
           }
            
            sum += nums[j];
            set.add(nums[j]);
            
            if(j-i+1 == k){
                maxSum = Math.max(sum,maxSum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        
        return maxSum != Long.MIN_VALUE ? maxSum : 0;
    }
}