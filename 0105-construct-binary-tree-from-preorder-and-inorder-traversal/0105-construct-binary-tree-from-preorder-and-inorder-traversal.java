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
    public TreeNode solve(int[] inorder,int[] preorder,int inStart,int inEnd,int pStart,int pEnd){
        if(inStart > inEnd || pStart > pEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);

        int i=inStart;

        for(;i<=inEnd;i++){
            if(inorder[i] == root.val)
            break;
        }

        int leftSize = i-inStart;
        int rightSize = inEnd-i;

        root.left = solve(inorder,preorder,inStart,i-1,pStart+1,pStart+leftSize);
        root.right = solve(inorder,preorder,i+1,inEnd,pStart+leftSize+1,pEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return solve(inorder,preorder,0,n-1,0,n-1);
    }
}