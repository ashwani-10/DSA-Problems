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
    public void dfs(TreeNode root,int[]count,int maxVal){
        if(root == null)return;

        if(root.val >= maxVal){
            count[0]++;
            maxVal = root.val;
        }

        dfs(root.left,count,maxVal);
        dfs(root.right,count,maxVal);
    }
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        if(root != null) dfs(root,count,root.val);

        return count[0];
    }
}
