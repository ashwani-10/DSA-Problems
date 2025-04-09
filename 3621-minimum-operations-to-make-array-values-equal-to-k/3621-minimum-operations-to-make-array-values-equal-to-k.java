class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            if(num < k){
                return -1;
            }
        }
        int count = 0;
        for(int num : set){
            if(num > k){
                count++;
            }
        }
        return count;
    }
}