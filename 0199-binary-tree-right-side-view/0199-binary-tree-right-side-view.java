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

// DFS
class Solution {
    void preOrder(TreeNode root,int level, List<Integer> res){
        if(root == null)
            return;
        
        if(res.size()<level){
            res.add(root.val);
        }
        
        preOrder(root.right,level+1,res);
        preOrder(root.left,level+1,res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();;
        
        preOrder(root,1,res);
        
        return res;
    }
}
