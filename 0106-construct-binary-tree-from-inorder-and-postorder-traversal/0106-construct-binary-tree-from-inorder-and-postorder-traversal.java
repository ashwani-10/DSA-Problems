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
    TreeNode build(int[] inOrder,int[] postOrder,int inStart,int inEnd,int postStart,int PostEnd){
        if(inStart > inEnd || postStart > PostEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(postOrder[PostEnd]);

        int i = inStart;

        for(;i<=inEnd;i++){
            if(inOrder[i] == root.val)
            break;
        }
        int leftSize = i-inStart;
        int rightSize = inEnd-i;

        root.left = build(inOrder,postOrder,inStart,i-1,postStart,postStart+leftSize-1);
        root.right = build(inOrder,postOrder,i+1,inEnd,PostEnd-rightSize,PostEnd-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder,postorder,0,n-1,0,n-1);
    }
}