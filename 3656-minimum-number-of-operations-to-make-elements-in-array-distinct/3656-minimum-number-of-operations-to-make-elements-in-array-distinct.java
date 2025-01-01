class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int index = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(set.contains(nums[i])){
                index = i;
                break;
            }
            set.add(nums[i]);
        }
        if(index == -1) return 0;
        int rem = (index + 1) %3;
        if(rem == 0) return (index+1)/3;
        return ((index+1)/3)+1;
    }
}