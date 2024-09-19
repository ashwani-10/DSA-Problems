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
    
    boolean inOrder(TreeNode root, int sum,int targetSum){
        if(root == null) return false;
        
        sum += root.val;
        // we reached leaf node
        if(root.left == null && root.right == null){
            if(sum == targetSum)
                return true;
            
            return false;
        }
        
        return inOrder(root.left,sum,targetSum) ||inOrder(root.right,sum,targetSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        
        return inOrder(root,sum,targetSum);
    }
}