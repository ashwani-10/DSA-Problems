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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
            
            while(!q.isEmpty()){
                    int size = q.size();
                    
                    while(size > 0){
                            TreeNode node = q.remove();
                            if(node.left != null) q.add(node.left);
                            if(node.right != null) q.add(node.right);
                            size--;
                    }
                    
                    if(!q.isEmpty()){
                            int temp = Integer.MIN_VALUE;
                            for(TreeNode node : q){
                                    if(node.val >= temp){
                                            temp = node.val;
                                    }
                            }
                            
                            res.add(temp);
                    }
            }
            return res;
    }
}