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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int levelSum = root.val;
        
        while(!que.isEmpty()){
            int size = que.size();
            int nextlevelSum = 0;
            
            while(size != 0){
                TreeNode curr = que.poll();
                curr.val = levelSum - curr.val;
                
                int siblingSum = (curr.left != null ? curr.left.val:0) + (curr.right != null ? (curr.right.val):0);
                
                if(curr.left != null){
                    nextlevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    que.add(curr.left);
                }
                if(curr.right != null){
                    nextlevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    que.add(curr.right);
                }
                size--;
            }
            
            levelSum = nextlevelSum;
        }
        return root;
    }
}