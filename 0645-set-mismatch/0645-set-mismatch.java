class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int idx = -1;
        int num = -1;
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                num = nums[i];
            }
        }

        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                idx = i;
                break;
            }
        }

        return new int[]{num,idx};
    }
}