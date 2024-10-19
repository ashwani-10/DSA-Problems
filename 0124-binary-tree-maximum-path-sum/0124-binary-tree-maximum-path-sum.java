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
    public static int findMax(TreeNode root,int[] sum){
        if(root == null) return 0;
        
        int ls = Math.max(0,findMax(root.left,sum));
        int rs = Math.max(0,findMax(root.right,sum));

        sum[0] = Math.max(sum[0],root.val+ls+rs);

        return root.val + Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right ==null) return root.val;
        int sum[] = new int[]{root.val};
        findMax(root,sum);
        return sum[0];
    }
}