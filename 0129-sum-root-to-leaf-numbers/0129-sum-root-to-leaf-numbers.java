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
    public static void helper(TreeNode root,int num,ArrayList<Integer> res){
        if(root==null) return;
        if(root.left == null && root.right == null) {
            num = num*10 + root.val;
            res.add(num);
            return;
        }
        
        num = num*10 + root.val;
        helper(root.left,num,res);
        helper(root.right,num,res);
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root,0,res);
        int sum = 0;
        for(int num : res){
            sum += num;
        }
        return sum;
    }
}