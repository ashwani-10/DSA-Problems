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
    int res = 0;
    public int findMax(TreeNode root){
        if(root == null) return 0;
        
        int lh = findMax(root.left);
        int rh = findMax(root.right);
        
        res = Math.max(res,lh+rh);
        
        return 1+Math.max(lh,rh);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return res;
    }
}