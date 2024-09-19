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
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    public boolean dfs(TreeNode root,int i,int count){
        if(root == null) return true;
        
        if(i > count) return false;
        
        return dfs(root.left,2*i,count) && dfs(root.right,2*i+1,count);
        
    }
    
    public boolean isCompleteTree(TreeNode root) {
        int count = countNodes(root);
        
        int i = 1;
        
        return dfs(root,i,count);
        
    }
}