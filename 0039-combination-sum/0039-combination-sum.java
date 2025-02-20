class Solution {
    List<List<Integer>> res;
    public void helper(int idx,int[] candidates,int target,List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(idx == candidates.length){
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if (candidates[i] > target) continue;
            temp.add(candidates[i]);
            helper(i,candidates,target-candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(0,candidates,target,new ArrayList<>());
        return res;
    }
}