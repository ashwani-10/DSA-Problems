class Solution {
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void helper(int[]nums,int idx,List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            helper(nums,idx+1,res);
            //backtrack
            swap(i,idx,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        return res;
    }
}