class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int num : nums){
            if(set.contains(num)){
                res ^= num;
            }
            set.add(num);
        }
        return res;
    }
}