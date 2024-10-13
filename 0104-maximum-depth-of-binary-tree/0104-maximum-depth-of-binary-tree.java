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
    public int maxDepth(TreeNode root) {
        // Your code here
        if(root == null) return 0;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int count = 0;

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> curr = new ArrayList<>();
            

            for(int i=0;i<size;i++){
            TreeNode node = que.remove();
            curr.add(node.val);
            if(node.left != null)
            que.add(node.left);
            if(node.right != null)
            que.add(node.right);
        }
        count++;

        }

        return count;
    }
}
