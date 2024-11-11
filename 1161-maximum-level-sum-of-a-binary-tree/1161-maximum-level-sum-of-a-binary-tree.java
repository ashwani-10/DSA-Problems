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

class pair{
    int mSum;
    int lvl;
    
    pair(int mSum,int lvl){
        this.mSum = mSum;
        this.lvl = lvl;
    }
}
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int mSum = Integer.MIN_VALUE;
        pair p = new pair(0,0);
        
        int lvl = 0;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            lvl++;
            int sum = 0;
            while(size > 0){
                TreeNode node = q.remove();
                sum += node.val;
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
                size--;
            }
            if(sum > mSum){
                mSum = sum;
                
                p = new pair(mSum,lvl);
            }
        }
        return p.lvl;
    }
}