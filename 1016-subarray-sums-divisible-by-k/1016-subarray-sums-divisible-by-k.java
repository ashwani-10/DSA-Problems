class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        int map[] = new int[k];
        map[0] = 1;
        int sum = 0;
        int count = 0;
        
        for(int num : nums){
            sum = (sum + num % k + k)%k;

            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}