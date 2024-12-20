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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
            
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
                TreeNode temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                size--;
            }
            
           level++;
           if(level %2 != 0 && !q.isEmpty()){
              int[] values = new int[q.size()];
              int i=0;
              for(TreeNode node : q){
                 values[i++] = node.val;
              }
                   
             int j = q.size()-1;
           for(TreeNode node : q){
              node.val = values[j--];
           }
           }
           
        }
        return root;
    }
}