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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        while(!que.isEmpty()){
            int size = que.size();
            long sum = 0;
            
            for(int i=0;i<size;i++){
            TreeNode curr = que.remove();
            
            if(curr.left != null) que.add(curr.left);
            if(curr.right != null) que.add(curr.right);
            sum += curr.val;
            }
            pq.add(sum);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.size() < k ? -1 : pq.peek();
    }
}