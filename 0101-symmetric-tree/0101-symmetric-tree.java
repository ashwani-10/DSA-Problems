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
    public boolean helper(TreeNode Left,TreeNode Right){
        if(Left == null && Right == null) return true;
        
        if(Left == null || Right == null) return false;
        
        if(Left.val != Right.val) return false;

        return helper(Left.left,Right.right) && helper(Left.right,Right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
}