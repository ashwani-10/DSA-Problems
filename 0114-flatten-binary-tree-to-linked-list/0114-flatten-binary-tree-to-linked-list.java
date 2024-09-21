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
    
    public void preOrder(TreeNode root,ArrayList<TreeNode> pre){
        if(root == null) return;
        
        pre.add(root);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }
    
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<>();
        
        preOrder(root,pre);
        
        for(int i=0;i<pre.size()-1;i++){
            pre.get(i).left = null;
            pre.get(i).right = pre.get(i+1);
        }
        if(pre.size()>1)
        pre.get(pre.size()-1).right = null;
    }
}