class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > k && !set.contains(num)){
                count++;
                set.add(num);
            }
            else if(num < k){
                return -1;
            }
        }
        return count;
    }
}