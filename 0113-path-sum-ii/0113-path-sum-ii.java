/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void solve(TreeNode root, int target,List<Integer> ans,List<List<Integer>> result){
        if(root == null)
            return;
        ans.add(root.val);
        if(root.left == null && root.right == null){
            if(target-root.val == 0)
                result.add(new ArrayList<>(ans));
        }
        
        solve(root.left,target-root.val,ans,result);
        solve(root.right,target-root.val,ans,result);
        
        ans.remove(ans.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        solve(root,targetSum,ans,result);
        return result;
    }
}