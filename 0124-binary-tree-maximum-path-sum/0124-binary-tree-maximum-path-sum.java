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
    static int maxi;
    public static int findMax(TreeNode root){
        if(root == null) return 0;
        
        int ls = Math.max(0,findMax(root.left));
        int rs = Math.max(0,findMax(root.right));

        maxi = Math.max(maxi,root.val+ls+rs);

        return root.val + Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right ==null) return root.val;
        maxi = Integer.MIN_VALUE;
        findMax(root);
        return maxi;
    }
}