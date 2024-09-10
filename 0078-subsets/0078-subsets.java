class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> subset = new ArrayList();
        helper(0,nums,subset,res);
        
        return res;
    }
    
    void helper(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        
        subset.add(nums[i]);
        helper(i+1,nums,subset,res);
        
        subset.remove(subset.size()-1);
        helper(i+1,nums,subset,res);
    }
}