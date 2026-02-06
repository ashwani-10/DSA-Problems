class Solution {
    public void helper(int i,int[] nums, List<List<Integer>> res,List<Integer> curr){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(i+1,nums,res,curr);

        curr.remove(curr.size()-1);
        helper(i+1,nums,res,curr);  
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,res,new ArrayList<>());
        return res;
    }
}