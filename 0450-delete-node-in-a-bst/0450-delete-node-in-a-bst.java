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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key && root.left == null && root.right == null) return null;
        
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            int is = succ(root.right,key);
            root.val = is;
            root.right = deleteNode(root.right,key);
        }
        
        if(root.val > key) root.left = deleteNode(root.left,key);
        else root.right = deleteNode(root.right,key);
        
        return root;
    }
    
    int succ(TreeNode root, int key){
            TreeNode cur = root;
            while(cur.left!=null) cur=cur.left;
            int temp = cur.val;
            cur.val = key;
            return temp;
        }
}